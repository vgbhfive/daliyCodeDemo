package cn.vgbh;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 寻找第k大元素
 * 
 * 例：
 * 给出数组 [9,3,2,4,8]，第三大的元素是 4
 * 给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，第三大的元素是 3，以此类推
 * 
 */

public class FindKthNum {

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,2,3,4,5,6,8,9,10,7};
		FindKthNum f = new FindKthNum();
		
//		System.out.println(f.getKthNum(arr, 10));
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + "\t");
//		}
		
		
		System.out.println(f.getKthNum(arr, 10));
		
		System.out.println(f.kthLargestElement(4, arr));
		
	}
	
	/**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        int result = 0;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        
        for (int i = 0; i < n; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }
	
	/**
	 * 获取第k大的数
	 * @param arr
	 * @param k
	 * @return Kth Number
	 */
	public int getKthNum (int[] arr, int k) {
//		//arr = bubbleSorting(arr);
////		
////		return arr[k-1];
//		
//		arr = quick(arr, 0, (arr.length-1));
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + "   ");
//		}
//		System.out.println();
//		
//		return arr[k-1];
		
		return 1;
	}

	/**
	 * 冒泡排序
	 * @param arr
	 * @return bubble Sorting Array
	 */
	private int[] bubbleSorting (int[] arr) {
		
		for(int x=0;x<arr.length;++x){
			for (int y=0;y<arr.length;++y) {
				if(y+1 == arr.length) break;
				if(arr[y] > arr[y+1]) {
					exchangeArrNum(arr, y, y+1);
				}
			}
		}
		
		return arr;
	}
	
	/**
	 * 数组的值交换
	 * @param arr
	 * @param x
	 * @param y
	 * @return exchanged Array
	 */
	private int[] exchangeArrNum (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return arr;
	}
	
	
	/**、
	 * 快速排序
	 * @param arr
	 * @param left
	 * @param right
	 * @return 快速排序后的数组
	 */
	public int[] quick(int[] arr, int left, int right) {
		if (arr.length > 0) {
			if (left < right) {
				int pivotpos = partition(arr, left, right);
				quick(arr, left, pivotpos - 1);// 左边
				quick(arr, pivotpos + 1, right);// 右边
			}
		}

		return arr;
	}

	/**
	 * 返回最后定位基准的下标
	 * @param arr
	 * @param left
	 * @param right
	 * @return 基准的下标
	 */
	public int partition(int[] arr, int left, int right) {
		int temp = arr[left];
		
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				--right; 
				// System.out.println("左移一次"); }
			}
			arr[left] = arr[right]; 
			// System.out.println("右边的支付给左边");
			while (left < right && arr[left] <= temp) {
				++left;
				// System.out.println("右移一次");
			}
			arr[right] = arr[left];
		}
		
		arr[left] = temp;
		// pc.prin(arr, n);

		return left;

		/*
		 * int pivot = arr[left]; // 枢轴记录 while (left < right) { while (left <
		 * right && arr[right] >= pivot) --right; arr[left] = arr[right]; //
		 * 交换比枢轴小的记录到左端 while (left < right && arr[left] <= pivot) ++left;
		 * arr[right] = arr[left]; // 交换比枢轴小的记录到右端 } // 扫描完成，枢轴到位 arr[left] =
		 * pivot; // 返回的是枢轴的位置 return left;
		 */

		
		/* 一次错误的示范
		 * for (int x=0;x<arr.length;x++) { if (arr[x] < temp) {
		 * 
		 * } else { int storeIndex = x; for (int y=storeIndex;y<arr.length;y++)
		 * { if (temp <= arr[y]) {
		 * 
		 * } else { swap(arr,x,y); break; } } }
		 * 
		 * }
		 */

		
		/* 两次错误的示范
		 * int pivot = arr[l]; 
		 * while (l < r) { 
		 *     while (l<r && arr[l]<=pivot) {
		 *         --r; 
		 *         if (l<r) {
		 *             arr[l] = arr[r];
		 *         } 
		 *     }
		 *     while (l<r && arr[r]>=pivot) {
		 *         ++l; 
		 *         if (l<r) { 
		 *         	arr[r] = arr[l]; 
		 *         }
		 *     }
		 * } 
		 * arr[l] = pivot; return l;
		 */

	}

	/*
	 * 对于1~10的有规律排序，快速排序可以进行排序。其他排序也一切正常。
	 */

	
}
