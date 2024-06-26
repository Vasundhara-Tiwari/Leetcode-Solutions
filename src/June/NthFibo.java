package June;

import java.util.Scanner;

public class NthFibo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(nthFibo(n));
    }
    public static int nthFibo(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int n1 = nthFibo(n-1);
        int n2 = nthFibo(n-2);
        return n1 + n2;
    }
}
