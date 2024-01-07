package January.Jan7;

import java.util.Scanner;

public class CoinToss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCoins = scanner.nextInt();
        printAllPossibleOutcomesOfCoinToss(numberOfCoins, "");
    }
    public static void printAllPossibleOutcomesOfCoinToss(int n, String result){
        if(n == 0){
            System.out.println(result);
            return;
        }
        printAllPossibleOutcomesOfCoinToss(n-1, result+"H");
        printAllPossibleOutcomesOfCoinToss(n-1, result+"T");
    }
}
