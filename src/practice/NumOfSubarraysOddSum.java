package practice;

public class NumOfSubarraysOddSum {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        int oddCount = 0;
        int evenCount = 1;
        int prefixSum = 0;
        int result = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        NumOfSubarraysOddSum ns = new NumOfSubarraysOddSum();
        System.out.println(ns.numOfSubarrays(arr));
    }
}
