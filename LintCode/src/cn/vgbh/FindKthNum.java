package cn.vgbh;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Ѱ�ҵ�k��Ԫ��
 * 
 * ����
 * �������� [9,3,2,4,8]���������Ԫ���� 4
 * �������� [1,2,3,4,5]����һ���Ԫ���� 5���ڶ����Ԫ���� 4���������Ԫ���� 3���Դ�����
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
	 * ��ȡ��k�����
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
	 * ð������
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
	 * �����ֵ����
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
	
	
	/**��
	 * ��������
	 * @param arr
	 * @param left
	 * @param right
	 * @return ��������������
	 */
	public int[] quick(int[] arr, int left, int right) {
		if (arr.length > 0) {
			if (left < right) {
				int pivotpos = partition(arr, left, right);
				quick(arr, left, pivotpos - 1);// ���
				quick(arr, pivotpos + 1, right);// �ұ�
			}
		}

		return arr;
	}

	/**
	 * �������λ��׼���±�
	 * @param arr
	 * @param left
	 * @param right
	 * @return ��׼���±�
	 */
	public int partition(int[] arr, int left, int right) {
		int temp = arr[left];
		
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				--right; 
				// System.out.println("����һ��"); }
			}
			arr[left] = arr[right]; 
			// System.out.println("�ұߵ�֧�������");
			while (left < right && arr[left] <= temp) {
				++left;
				// System.out.println("����һ��");
			}
			arr[right] = arr[left];
		}
		
		arr[left] = temp;
		// pc.prin(arr, n);

		return left;

		/*
		 * int pivot = arr[left]; // �����¼ while (left < right) { while (left <
		 * right && arr[right] >= pivot) --right; arr[left] = arr[right]; //
		 * ����������С�ļ�¼����� while (left < right && arr[left] <= pivot) ++left;
		 * arr[right] = arr[left]; // ����������С�ļ�¼���Ҷ� } // ɨ����ɣ����ᵽλ arr[left] =
		 * pivot; // ���ص��������λ�� return left;
		 */

		
		/* һ�δ����ʾ��
		 * for (int x=0;x<arr.length;x++) { if (arr[x] < temp) {
		 * 
		 * } else { int storeIndex = x; for (int y=storeIndex;y<arr.length;y++)
		 * { if (temp <= arr[y]) {
		 * 
		 * } else { swap(arr,x,y); break; } } }
		 * 
		 * }
		 */

		
		/* ���δ����ʾ��
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
	 * ����1~10���й������򣬿���������Խ���������������Ҳһ��������
	 */

	
}
