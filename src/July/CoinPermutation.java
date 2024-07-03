package July;

public class CoinPermutation {
    public static void main(String[] args) {
        int[] coins = {2, 3,5};
        int target = 8;
        permutation(coins, target, "", 0);
    }

    private static void permutation(int[] coins, int target, String ans, int amount) {
        if(amount == target){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < coins.length; i++){
            if(amount < target){
                permutation(coins, target, ans+coins[i], amount+coins[i]);
            }
        }
    }
}
