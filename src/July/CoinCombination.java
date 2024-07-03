package July;

public class CoinCombination {
    public static void main(String[] args) {
        int[] coins = {2, 3,5};
        int target = 8;
        combination(coins, target, "", 0, 0);
    }
    private static void combination(int[] coins, int target, String ans, int amount, int index) {
        if(amount == target){
            System.out.println(ans);
            return;
        }
        for(int i = index; i < coins.length; i++){
            if(amount < target){
                combination(coins, target, ans+coins[i], amount+coins[i], i);
            }
        }
    }
}
