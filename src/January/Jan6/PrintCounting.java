package January.Jan6;

public class PrintCounting {
    public static void main(String[] args) {
        int n = 5;
        printNums(n);
    }
    public static void printNums(int n){
        if(n == 0){
            return;
        }
        printNums(n-1);
        System.out.println(n);
    }
}
