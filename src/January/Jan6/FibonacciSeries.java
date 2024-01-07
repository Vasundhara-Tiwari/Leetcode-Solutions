package January.Jan6;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(printNthFibonacci(10));
    }
    public static int printNthFibonacci(int n){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int num1 = printNthFibonacci(n-1);
        int num2 = printNthFibonacci(n-2);
        return num1 + num2;
    }
}
