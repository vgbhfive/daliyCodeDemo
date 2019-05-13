package cn.vgbhfive;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import cn.vgbhfive.DataMoniter.DataMoniterListener;

/**
 * @auther Vgbh
 *
 * 这是一个简单的示例程序，使用DataMoniter来启动和停止基于znode的可执行文件。
 * 程序监视指定的znode并保存与文件系统中相对应的数据。
 * 当znode存在时，使用制定的参数启动程序，若不存在，则不执行。
 */
public class Executor implements Watcher, Runnable, DataMoniterListener{
	
	String znode;
	DataMoniter dm;
	ZooKeeper zk;
	String filename;
	String exec[];
	Process child;
	
	public Executor(String hostPort, String znode, String filename, String[] exec) throws IOException {
		this.filename = filename;
		this.exec = exec;
		zk = new ZooKeeper(hostPort, 3000, this);
		dm = new DataMoniter(zk, znode, null, this);
	}

	public static void main(String[] args) {
		if (args.length < 4) {
			System.err.println("USAGE:Executor hostPort znode filename program [args ...]");
			System.exit(2);
		}
		String hostPort = args[0];
		String znode = args[1];
		String filename = args[2];
		String exec[] = new String[args.length - 3];
		System.arraycopy(args, 3, exec, 0, exec.length);
		try {
			new Executor(hostPort, znode, filename, exec).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exists(byte[] data) {
		if (data == null) {
			if (child != null) {
				System.out.println("Killing process.");
				child.destroy();
				try {
					child.waitFor();
				} catch (InterruptedException e) {
				}
			}
			child = null;
		} else {
			if (child != null) {
				System.out.println("Stopping process.");
				child.destroy();
				try {
					child.waitFor();
				} catch (InterruptedException e) {
				}
			}
			
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(filename);
				fos.write(data);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				System.out.println("Starting child.");
				child = Runtime.getRuntime().exec(exec);
				new StreamWriter(System.out, child.getInputStream());
				new StreamWriter(System.err, child.getErrorStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closing(int rc) {
		synchronized (this) {
			notifyAll();
		}
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				while (!dm.dead) {
					wait();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 不需要做任何事，只要转发即可。
	 */
	@Override
	public void process(WatchedEvent event) {
		dm.process(event);
	}
	
	static class StreamWriter extends Thread {
		OutputStream os;
		InputStream is;
		
		public StreamWriter(OutputStream os, InputStream is) {
			this.os = os;
			this.is = is;
		}
		
		@Override
		public void run() {
			byte b[] = new byte[80];
			int rc;
			try {
				while ((rc = is.read(b)) > 0) {
					os.write(b, 0, rc);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
