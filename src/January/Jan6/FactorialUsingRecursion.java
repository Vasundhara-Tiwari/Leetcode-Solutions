package January.Jan6;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
    public static int factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return factorial(n-1) * n;
    }
}
