package June;

import java.util.Scanner;

public class LexicographicalCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printAll(num, 0);
    }

    private static void printAll(int num, int current) {
        if (current > num){
            return;
        }
        System.out.println(current);
        int i = 0;
        if(current == 0){
            i = 1;
        }
        for (; i <= 9; i++){
            printAll(num, current*10 + i);
        }
    }
}
