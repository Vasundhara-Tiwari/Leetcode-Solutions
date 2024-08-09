package August;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {-1,-1,1};
        int sum = 0;
        System.out.println(subarraySum(arr, sum));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
