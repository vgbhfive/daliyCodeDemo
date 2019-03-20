package cn.vgbh.divideAndConquer;

/*
 * 归并排序
 */

public class MergeSorting {
	
	/*
	 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法
	 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用
	 * 
	 * 归并排序算法思路：分治法
	 * 1、把 n 个记录看成 n 个长度为 l 的有序子表
	 * 2、进行两两归并使记录关键字有序，得到 n/2 个长度为 2 的有序子表
	 * 3、重复第 2 步直到所有记录归并成一个长度为 n 的有序表为止。
	 */
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{12,3,24,532,123,667,55,0,789,654};
		
		MergeSorting ms = new MergeSorting();
		arr = ms.merge(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "   ");
		}
		
	}
	
	/**
	 * 归并排序入口
	 * @param arr
	 * @param n
	 */
	public int[] merge (int arr[]) {
		int[] temp = new int[arr.length];
		arr = mergeSort(arr,0,arr.length-1,temp);
		
		return arr;
	}
	
	/**
	 * 归并排序
	 * @param arr
	 * @param first
	 * @param last
	 * @param temp
	 */
	private int[] mergeSort (int arr[],int first,int last,int temp[]) {
		if (first < last) {
			int bin = (first + last) / 2;
			mergeSort(arr,first,bin,temp);				//左边
			mergeSort(arr,bin+1,last,temp);				//右边
			arr = mergeArray(arr,first,bin,last,temp);	//数组排序
		}
		
		return arr;
	}
	
	/**
	 * 合并数组
	 * 首先考虑下如何将将二个有序数列合并为一个数组这个非常简单，只要从比较二个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数，
	 * 然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可.
	 * 
	 * @param arr
	 * @param first
	 * @param bin
	 * @param last
	 * @param temp
	 */
	private int[] mergeArray (int arr[],int first,int bin,int last,int temp[]) {
		int i = first;//第一个数组的初始位
		int m = bin;//第一个数组的末尾
		int j = bin + 1;//第二个数组的初始位
		int n = last;//第二个数组的末尾
		int k = 0;//替补数组长度
				
		while (i<=m && j<=n) {
			if (arr[i] <= arr[j]) {
				//temp[k] = arr[i];		k++;			i++;
				temp[k++] = arr[i++];
				//System.out.println("temp[k]  " + temp[k-1] + "    k " + (k-1) + "   i " + i + "这里是i");
			} else {
				//temp[k] = arr[j];		k++;			j++;
				temp[k++] = arr[j++];
				//System.out.println("temp[k]  " + temp[k-1] + "    k " + (k-1) + "   j " + j + "这里是j");
			}
		}
		
		while (j <= n) {//补偿未排序进数组的数
			//temp[k] = arr[j];			k++;			j++;
			temp[k++] = arr[j++];
			//System.out.println("temp[k]" + temp[k-1] + "    k" + (k-1) + "   j" + j);
		}
		
		while (i <= m) {//补偿未排序进数组的数
			//temp[k] = arr[i];			k++;			i++;
			temp[k++] = arr[i++];
			//System.out.println("temp[k]  " + temp[k-1] + "    k  " + (k-1) + "   i  " + i);
		}
		
		for (int x=0;x<k;x++) {
			arr[first+x] = temp[x];
		}
		
		return arr;
	}

}

	
