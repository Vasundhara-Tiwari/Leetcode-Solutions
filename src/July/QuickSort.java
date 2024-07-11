package July;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 8, 1, 4};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        int index = partition(arr, si, ei);
        sort(arr, si, index-1);
        sort(arr, index+1, ei);
    }
    private static int partition(int[] arr, int si, int ei) {
        int index = si;
        int item = arr[ei];
        for (int i = si; i < ei; i++) {
            if(arr[i] < item){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        int temp = arr[ei];
        arr[ei] = arr[index];
        arr[index] = temp;
        return index;
    }
}
