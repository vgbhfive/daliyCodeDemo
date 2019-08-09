#### BTrace

##### 简介
BTrace 是检查和解决线上的问题的杀器，BTrace 可以通过编写脚本的方式，获取程序执行过程中的一切信息，**不用重启服务**。写好脚本，直接用命令执行即可，不用动原程序的代码。

总体来说，BTrace 是基于动态字节码修改技术(Hotswap )来实现运行时Java 程序的跟踪和替换。
大体的原理可以用下面的公式描述：Client(Java compile api + attach api) + Agent（脚本解析引擎 + ASM + JDK6 Instumentation） + Socket。其实BTrace 就是使用了java attach api 附加agent.jar ，然后使用脚本解析引擎+asm 来重写指定类的字节码，再使用instrument 实现对原有类的替换。

##### 安装
1. 从[Github](https://github.com/btraceio/btrace/releases/tag/v1.3.11.3) 上下载源码。
2. 解压源码到文件夹下，并配置对应的环境变量JAVA_HOME、 BTRACE_HOME 即可。

##### 使用场景
BTrace 是一个事后工具，所谓事后工具就是指在服务已经上线，但是发现存在以下问题的时候，可以用 BTrace：
 - 比如哪些方法执行太慢。例如监控执行时间超过1s的方法。
 - 查看哪些方法调用了System.gc() ，调用栈是怎样的。
 - 查看方法参数或对象属性。
 - 哪些方法发生了异常。

为了保证trace 语句只读，最小化对被检测程序造成影响，BTrace 对trace 脚本有一些限制：
 - BTrace class 不能新建类，新建数组，抛异常，捕获异常。
 - 不能调用实例方法以及静态方法。(com.sun.btrace.BTraceUtils除外)
 - 不能将目标程序和对象赋值给BTrace 的实例和静态field 。 
 - 不能定义外部、内部、匿名、本地类。
 - 不能有同步块和方法。
 - 不能有循环。
 - 不能实现接口，不能扩展类。
 - 不能使用assert语句，不能使用class 字面值。

##### 简单示例
BTrace 的语法很简单，只需要知道需要探测的Java 程序的PID 即可，然后编写一个探测脚本。
```sh
btrace <pid> script.java
```

1. 写一个常驻内存的Java 程序
```Java
/**
 * @auther Vgbh
 *
 */
public class b {
    public static void main(String[] args) {
        new b().hello(100000);
    }

    public void hello(Integer x) {
        for (int i = 0; i < x; i++) {
            if ((i%100) == 0) {
                Object obj = new Object();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " Hello World!");
        }
    }
}
```

2. 获取Java 程序的进程ID
```sh
C:\Users\Vgbh>jps
18048
6736 b
18760 Jps
21420
```

3. 编写BTrace 脚本
```Java
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.Strings.strcat;
import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;

/**
 * @auther Vgbh
 *
 */
@BTrace
public class BTraceTest {
  
  @OnMethod(clazz="jvmTest.b", method="hello", location=@Location(Kind.ENTRY))
  public static void func(@Return int entry) {
    println("BTrace ---------------");
    println("Entry: " + str(entry));
    jstack();
  }
}
```

4. 预编译脚本，检查脚本的正确性
```sh
btracec BTraceTest.java
```

5. 调用命令执行
```sh
btrace 6736  BTraceTest.java > log.log
```

6. 退出
按Ctrl + C 页面会给出提示，再按1 即可退出。