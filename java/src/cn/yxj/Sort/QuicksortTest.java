package cn.yxj.Sort;

import java.util.Arrays;

/**
 * @author yangxj
 * @date 2019-3-27 9:16
 */
public class QuicksortTest {
    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

        public static void quickSort(int[] arr, int left, int right) {
            if(left>right){
                return;
            }
            //将第一个数作为基准位
            int l =left;
            int r =right;
            int basic = arr[left];
            while(l<r) {
                // 从右找到第一个小于基准位的数
                while (arr[r]>=basic && l<r){
                    r--;
                }
                // 从左边找到第一个大于基准位的数
                while(arr[l]<=basic && l<r){
                    l++;
                }
                //交换两者位置
                int temp = arr[r];
                arr[r] =  arr[l];
                arr[l] =temp;
            }
            //最后将基准位与i和j相等位置的数字交换
            arr[left] = arr[l]; // or arr[left] = arr[r]
            arr[l] = basic;
            //递归调用左半数组
            quickSort(arr, left, r-1);
            //递归调用右半数组
            quickSort(arr, r+1, right);
        }
    }
