package January.Jan6;

import java.util.Scanner;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isPowerOfTwo(n));
    }
    public static boolean isPowerOfTwo(int n) {
        if((n != 1 && n%2 == 1) || n == 0){
            return false;
        }
        else if(n == 1){
            return true;
        }
        return isPowerOfTwo(n/2);
    }
}
