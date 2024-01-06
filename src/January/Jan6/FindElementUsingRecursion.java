package January.Jan6;

public class FindElementUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,5,2,6,2,6};
        int k = 10;
        System.out.println(find(arr, k, 0));
    }
    public static int find(int[] arr, int k, int index){
        if(arr[index] == k){
            return index;
        }
        if(index == arr.length-1){
            return -1;
        }
        return find(arr, k, index+1);
    }
}
