package January.Jan6;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int factorial(int n){
        int fact = 1;
        if(n == 1 || n == 0){
            return 1;
        }
        fact = factorial(n-1) * n;
        return fact;
    }
}
