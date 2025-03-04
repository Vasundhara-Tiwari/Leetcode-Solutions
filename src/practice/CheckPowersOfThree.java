package practice;

import java.util.Scanner;

public class CheckPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        while(n > 0){
            if(n % 3 == 2){
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        CheckPowersOfThree cp = new CheckPowersOfThree();
        System.out.println(cp.checkPowersOfThree(n));
    }
}
