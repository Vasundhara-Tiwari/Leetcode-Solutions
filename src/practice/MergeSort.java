package practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] res = sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(res));
    }
    public static int[] sort(int[] arr, int si, int ei){
        if (si == ei){
            int[] bs = new int[1];
            bs[0] = arr[si];
            return bs;
        }
        int mid = (si + ei) / 2;
        int[] left = sort(arr, si, mid);
        int[] right = sort(arr, mid+1, ei);
        return merge(left, right);
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int[] ans = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                k++;
                i++;
            } else {
                ans[k] = arr2[j];
                k++;
                j++;
            }
        }
        if(arr2.length == j){
            while(i < arr1.length){
                ans[k] = arr1[i];
                i++;
                k++;
            }
        }
        if(arr1.length == i){
            while (j < arr2.length){
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        return ans;
    }
}
