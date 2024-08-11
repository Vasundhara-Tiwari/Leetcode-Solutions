package practice;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int si, int ei){
        if (si > ei){
            return;
        }
        int index = partition(arr, si, ei);
        sort(arr, si, index-1);
        sort(arr, index+1, ei);
    }
    public static int partition(int[] arr, int si, int ei){
        int index = 0;
        int i = 0;
        int item = arr[ei];
        while (i < ei){
            if (arr[index] < item){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
            i++;
        }
        int temp = arr[index];
        arr[index] = arr[ei];
        arr[ei] = temp;
        return index;
    }
}
