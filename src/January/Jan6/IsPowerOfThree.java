package January.Jan6;

import java.util.Scanner;

public class IsPowerOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isPowerOfThree(n));
    }
    public static boolean isPowerOfThree(int n) {
        if(n == 1 || n == 3){
            return true;
        }
        if(n%3 != 0 || n == 0){
            return false;
        }
        return isPowerOfThree(n/3);
    }
}
