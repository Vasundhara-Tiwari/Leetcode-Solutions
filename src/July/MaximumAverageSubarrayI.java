package July;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;
        int start = 0;
        int end = 0;
        double maxAvg=-999999999;
        double currentSum=0;
        while(end < nums.length){
            if(end - start + 1 == k){
                currentSum+=nums[end];
                double avg = currentSum / k;
                maxAvg = Math.max(maxAvg, avg);
                currentSum -= nums[end];
            }
            if(end - start + 1 > k){
                currentSum -= nums[start];
                start++;
            } else {
                currentSum += nums[end];
                end++;
            }
        }
        System.out.println(maxAvg);
    }
}
