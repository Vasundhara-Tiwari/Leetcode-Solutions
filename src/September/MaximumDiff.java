package September;

public class MaximumDiff {
    public static void main(String[] args)
    {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int n = arr.length;
        int[] rightMaximum = new int[n];
        rightMaximum[n-1] = arr[n-1];
        for (int k = n-2; k >= 0; k--){
            rightMaximum[k] = Math.max(arr[k], rightMaximum[k +1]);
        }
        int[] leftMinimum = new int[n];
        leftMinimum[0] = arr[0];
        for (int l = 1; l < n; l++){
            leftMinimum[l] = Math.min(arr[l], leftMinimum[l -1]);
        }

        int i = 0;
        int j = 0;
        int diff = -1;
        while (j < n && i < n){
            if(leftMinimum[i] <= rightMaximum[j]){
                diff = Math.max(j - i, diff);
                j++;
            } else {
                i++;
            }
        }
        System.out.println(diff);
    }
}
