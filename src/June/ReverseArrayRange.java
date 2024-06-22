package June;

import java.util.Arrays;

public class ReverseArrayRange {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 7, 8, 6, 9, 11, 15, 17, 18, 26, 23, 27};
        int i = 5;
        int j = 10;
        System.out.println(Arrays.toString(arr));
        reverse(arr, i, j);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
