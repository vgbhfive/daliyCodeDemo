package jvmTest;

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
