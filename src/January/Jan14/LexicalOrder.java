package January.Jan14;

public class LexicalOrder {
    public static void main(String[] args) {
        int n = 1000;
        printLexicalOrder(n, 0);
    }
    public static void printLexicalOrder(int n, int current){
        if(current > n){
            return;
        }
        System.out.println(current);
        int i = 0;
        if(current == 0){
            i = 1;
        }
        for(; i <= 9; i++){
            printLexicalOrder(n, current*10 + i);
        }
    }
}
