package July;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        int zero = minCost(arr, 0);
        int first = minCost(arr, 1);
        System.out.println(Math.min(zero, first));
    }
    public static int minCost(int[] arr, int i){
        if(i >= arr.length){
            return 0;
        }
        int singleStep = minCost(arr, i+1);
        int twoStep = minCost(arr, i+2);
        int ans = arr[i] + Math.min(singleStep, twoStep);
        return ans;
    }
}
