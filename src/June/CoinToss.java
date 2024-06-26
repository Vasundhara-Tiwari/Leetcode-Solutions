package June;

import java.util.Scanner;

public class CoinToss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coins = scanner.nextInt();
        printPossibleOutcomes(coins, "");
    }

    private static void printPossibleOutcomes(int coins, String ans) {
        if(coins == 0){
            System.out.println(ans);
            return;
        }
        printPossibleOutcomes(coins-1, ans+"H");
        printPossibleOutcomes(coins-1, ans+"T");
    }
}
