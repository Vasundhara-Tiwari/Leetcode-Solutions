package June;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cows = scanner.nextInt();
        int[] stalls = new int[n];
        for(int i = 0; i < stalls.length; i++){
            stalls[i] = scanner.nextInt();
        }
        Arrays.sort(stalls);
        System.out.println(largestMinimumDistance(stalls, cows));
    }
    public static int largestMinimumDistance(int[] stalls, int cows){
        int ans = 0;
        int low = 0;
        int high = stalls[stalls.length - 1] - stalls[0];
        while (low <= high){
            int mid = (low + high) / 2;
            if(isPossible(stalls, cows, mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] stalls, int cows, int distance){
        int cow = 1;
        int pos = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - pos >= distance){
                pos = stalls[i];
                cow++;
            }
            if(cow == cows){
                return true;
            }
        }
        return false;
    }
}
