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

}
