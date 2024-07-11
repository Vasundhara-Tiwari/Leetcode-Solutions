package July;

import java.util.Arrays;

// elements on left should be smaller and elements on right should be greater
public class PartitionArray {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 8, 1, 4};
        partition(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void partition(int[] arr, int si, int ei) {
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
    }
}
