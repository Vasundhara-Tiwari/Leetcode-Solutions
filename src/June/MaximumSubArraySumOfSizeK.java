package June;


//Sliding Window
public class MaximumSubArraySumOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 7, 2, 6, 4, 5};
        int k = 3;
        System.out.println(maxSum(arr, k));
    }

    private static int maxSum(int[] arr, int k) {
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        for(int i = k; i < arr.length; i++){
            sum+=arr[i];
            sum-=arr[i-k];
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
