package July;

import java.util.ArrayList;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        ArrayList<String> al = new ArrayList<>();
        numOfCoins(coins, amount, al, "", 0);
        System.out.println(al);
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i).length() < len){
                len = al.get(i).length();
            }
        }
        System.out.println(len);
    }

    private static void numOfCoins(int[] coins, int amount, ArrayList<String> al, String ans, int index) {
        if(amount == 0){
            al.add(ans);
            return;
        }
        if (index >= coins.length || amount < 0){
            return;
        }
        numOfCoins(coins, amount-coins[index], al, ans+coins[index],index);
        numOfCoins(coins, amount, al, ans, index+1);
    }
}
