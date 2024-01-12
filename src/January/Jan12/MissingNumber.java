package January.Jan12;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        long actualSum = (n*(n+1))/2;
        long sum = 0;
        for(int element: nums)
        {
            sum += element;
        }
        return (int)(actualSum-sum);
    }
}
