package practice;

public class MaximumAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, maxSumSoFar = 0, minSumSoFar = 0;

        for (int num : nums) {
            maxSumSoFar += num;
            minSumSoFar += num;

            maxSum = Math.max(maxSum, maxSumSoFar);
            minSum = Math.min(minSum, minSumSoFar);

            if (maxSumSoFar < 0) maxSumSoFar = 0;
            if (minSumSoFar > 0) minSumSoFar = 0;
        }
        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        MaximumAbsoluteSum mas = new MaximumAbsoluteSum();
        int[] arr = {2,-5,1,-4,3,-2};
        System.out.println(mas.maxAbsoluteSum(arr));
    }
}
