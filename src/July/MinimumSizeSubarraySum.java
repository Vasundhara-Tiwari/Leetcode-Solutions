package July;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, arr));
    }
    public static int minSubArrayLen(int target, int[] arr) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int l = Integer.MAX_VALUE;
        while(i < arr.length){
            sum+=arr[i];
            while(sum >= target){
                l = Math.min(l, i - j + 1);
                sum -= arr[j];
                j++;
            }
            i++;
        }
        return (l == Integer.MAX_VALUE) ? 0 : l;
    }
}
