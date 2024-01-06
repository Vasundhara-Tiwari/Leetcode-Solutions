package January.Jan6;

public class FactorialUsingTailRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(10, 1));
    }
    public static int factorial(int n, int fact){
        if(n == 1 || n == 0){
            return fact;
        }
        fact *= n;
        return factorial(n-1, fact);
    }
}
