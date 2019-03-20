package cn.vgbh;

/*
 * LFU是一个著名的缓存算法
 * LFU:最近不常使用置换算法（Least Frequently Used），也就是淘汰一定时期内的访问次数最少的页。
 * 实现LFU中的set 和 get
 * 
 * 样例：
 * capacity = 3
 * 
 * set(2,2)
 * set(1,1)
 * get(2)
 * >> 2
 * get(1)
 * >> 1
 * get(2)
 * >> 2
 * set(3,3)
 * set(4,4)
 * get(3)
 * >> -1
 * get(2)
 * >> 2
 * get(1)
 * >> 1
 * get(4)
 * >> 4
 */

public class LFUCache {
	
	private static Integer[] mapKey= null;
	private Integer[] mapValue = null;
	private Integer[] num = null;
	private int index = 0;
	
	/**
	 * 初始化LFUCache
	 */
	public LFUCache(int capacity) {
		// initialization
		mapKey = new Integer[capacity];
		mapValue = new Integer[capacity];
		num = new Integer[capacity];
		for (int i = 0; i < num.length; i++) {
			num[i] = 0;
		}
	}

	/**
	 * map中添加key和value
	 * @param key
	 * @param value
	 */
	public void set (int key, int value) {
		if (index < 3) {
			if (hashDouble(key) != -1) {
				mapValue[hashDouble(key)] = value;
			} else {
				System.out.println("sssssssssssssss");
				mapKey[index] = key;
				mapValue[index] = value;
				index++;
			}
		} else {
			int min = num[0];
			int index = 0;
			for (int i = 0; i < num.length; i++) {
				if (num[i] < min) {
					min = num[i];
					index = i;
				}
			}
			mapKey[index] = key;
			mapValue[index] = value;
		}
		
	}
	
	/**
	 * 使用key获取value
	 * @param key
	 * @return
	 */
	public int get (int key) {
		for (int i = 0; i < mapKey.length; i++) {
			if (mapKey[i] == key) {
				num[i] += 1;
				return mapValue[i];
			}
		}
		return -1;
	}
	
	private int hashDouble (int key) {
		for (int i = 0; i < mapKey.length; i++) {
			//System.out.println(mapKey[i]);
			if (mapKey[i] != null) {
				System.out.println("      i:" + i);
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(3);
		lfu.set(1, 1);
		lfu.set(1, 2);
		lfu.set(3, 3);
		System.out.println(lfu.get(1));
//		lfu.set(4, 4);
//		System.out.println(lfu.get(4));
//		System.out.println(lfu.get(3));
//		System.out.println(lfu.get(2));
//		System.out.println(lfu.get(1));
	}

}
