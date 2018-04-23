package cn.yxj.Sort;

import java.util.Arrays;

public class QuickSort {
	/**
	 * 快速排序
	 * 
	 * @param strDate
	 * @param left
	 * @param right
	 */
	public static void main(String[] args) {
		int[]  arr={2,4,1,3,5,3};
		int left=0;
		int right=5;
		System.out.println(Arrays.toString(arr));
		quickSort(arr,left,right);
		System.out.println(Arrays.toString(arr));
	}
	public  static void quickSort(int[] strDate, int left, int right) {
		int middle, tempDate;
		int i, j;
		i = left;
		j = right;
		middle = strDate[(i + j) / 2];
		do {
			while (strDate[i]<strDate[middle] && i < right)
				i++; // 找出左边比中间值大的数
			while (strDate[i]>strDate[middle] && j > left)
				j--; // 找出右边比中间值小的数
			if (i <= j) { // 将左边大的数和右边小的数进行替换
				tempDate = strDate[i];
				strDate[i] = strDate[j];
				strDate[j] = tempDate;
				i++;
				j--;
			}
		} while (i <= j); // 当两者交错时停止

		if (i < right) {
			quickSort(strDate, i, right);
		}
		if (j > left) {
			quickSort(strDate, left, j);
		}
	}
}
