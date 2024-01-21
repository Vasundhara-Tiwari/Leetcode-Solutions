package January.Jan21;

import java.util.ArrayList;

public class CoinChange {
    static ArrayList<String> al = new ArrayList<>();
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        coinChanges(coins, amount, "", 0);
        System.out.println(al.size());
    }
    public static void coinChanges(int[] coins, int amount, String ans, int index){
        if(amount == 0){
            al.add(ans);
            return;
        }
        for(int i = index; i < coins.length; i++){
            if(amount >= coins[i]){
                coinChanges(coins, amount - coins[i], ans + coins[i], i);
            }
        }
    }
}
