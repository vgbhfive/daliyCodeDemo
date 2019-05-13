package cn.vgbhfive;

import java.util.Arrays;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @auther Vgbh
 *
 * 监视ZooKeeper的节点数据是否存在的类，使用ZooKeeper的异步API。
 */
public class DataMoniter implements Watcher, StatCallback{
	
	ZooKeeper zk;
	String znode;
	Watcher chaineWatcher;
	Boolean dead;
	DataMoniterListener listener;
	byte prevData[];
	
	public DataMoniter(ZooKeeper zk, String znode, Watcher chaineWatcher, DataMoniterListener listener) {
		this.zk = zk;
		this.znode = znode;
		this.chaineWatcher = chaineWatcher;
		this.listener = listener;
		// 
		zk.exists(znode, true, this, null);
	}

	/**
	 * @author Vgbh
	 * 其他类通过这个类来实现DataMoniterListener
	 */
	public interface DataMoniterListener{
		void exists(byte data[]);
		void closing(int rc);
	}
	
	@Override
	public void processResult(int rc, String path, Object ctx, Stat stat) {
		boolean exists = false;
		switch (rc) {
		case Code.Ok:
			exists = true;
			break;
		case Code.NoNode:
			exists = false;
			break;
		case Code.SessionExpired:
		case Code.NoAuth:
			dead = true;
			listener.closing(rc);
			return;
		default:
			zk.exists(znode, true, this, null);
			break;
		}
		byte b[] = null;
		if (exists) {
			try {
				b = zk.getData(path, false, null);
			} catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				return;
			}
		}
		
		if ((b == null && b != prevData) || (b != null && !Arrays.equals(prevData, b))) {
			 listener.exists(b);
			 prevData = b;
		}
	}

	@Override
	public void process(WatchedEvent event) {
		String path = event.getPath();
		if (event.getType() == Event.EventType.None) {
			switch (event.getState()) {
			case SyncConnected:
				break;
			case Expired:
				dead = true;
				listener.closing(KeeperException.Code.SessionExpired);
				break;
			}
		} else {
			if (path != null && path.equals(znode)) {
				zk.exists(znode, true, this, null);
			}
		}
		if (chaineWatcher != null) {
			chaineWatcher.process(event);
		}
	}
	
}
