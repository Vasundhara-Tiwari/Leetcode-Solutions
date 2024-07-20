package July;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(noOfWays(coins, amount, 0, dp));
        System.out.println(noOfWaysBU(coins, amount));
    }

    private static int noOfWays(int[] coins, int amount, int index, int[][] dp) {
        if (index >= coins.length || amount < 0){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        if (dp[index][amount] != -1){
            return dp[index][amount];
        }
        int pick = noOfWays(coins, amount-coins[index], index, dp);
        int notPick = noOfWays(coins, amount, index+1, dp);
        return dp[index][amount] = pick + notPick;
    }

    private static int noOfWaysBU(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length+1];
        dp[0][0] = 1;
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int am = 1; am < dp.length; am++) {
            for (int i = 1; i < dp[0].length; i++) {
                int inc = 0, exc = 0;
                if (coins[i -1] <= am){
                    inc = dp[am - coins[i -1]][i];
                }
                exc = dp[am][i -1];
                dp[am][i] = inc + exc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
