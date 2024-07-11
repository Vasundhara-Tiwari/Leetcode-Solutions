package July;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 4, 3};
        int[] result = sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sort(int[] arr, int si, int ei) {
        if(si == ei){
            int[] bs = new int[1];
            bs[0] = arr[si];
            return bs;
        }
        int mid = (si+ei)/2;
        int[] firstArray = sort(arr, si, mid);
        int[] secondArray = sort(arr, mid+1, ei);
        return merge(firstArray, secondArray);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                i++;
                k++;
            } else {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        if (arr1.length == i) {
            while (j < arr2.length) {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        if (arr2.length == j) {
            while (i < arr1.length) {
                ans[k] = arr1[i];
                i++;
                k++;
            }
        }
        return ans;
    }
}
