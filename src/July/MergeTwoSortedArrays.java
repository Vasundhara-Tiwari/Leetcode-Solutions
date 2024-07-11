package July;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 4, 5, 7, 8, 11 };
        int[] arr2 = { 1, 2, 5, 6, 9, 11, 13, 14 };
        int[] result = mergeSortedArrays(arr1, arr2, 0, 0);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2, int i, int j) {
        int[] ans = new int[arr1.length + arr2.length];
        int k = 0;
        while (i < arr1.length && j < arr2.length && k < ans.length){
            if(arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                i++;
                k++;
            } else {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        if(arr1.length == i){
            while(j < arr2.length) {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        if(arr2.length == i){
            while(i < arr1.length) {
                ans[k] = arr1[i];
                i++;
                k++;
            }
        }
        return ans;
    }
}
