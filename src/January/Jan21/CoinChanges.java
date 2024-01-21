package January.Jan21;

public class CoinChanges {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        coinChanges(coins, amount, "");
    }
    public static void coinChanges(int[] coins, int amount, String ans){
        if(amount == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < coins.length; i++){
            if(amount >= coins[i]){
                coinChanges(coins, amount - coins[i], ans + coins[i]);
            }
        }
    }
}
