package January.Jan7;

public class DiceRoll {
    static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        printPath(n, "");
        System.out.println(countPaths(n, ""));
    }
    public static void printPath(int n, String ans){
        if(n < 0){
            return;
        }
        if(n == 0){
            System.out.println(ans);
            return;
        }
        printPath(n-1, ans+"1");
        printPath(n-2, ans+"2");
        printPath(n-3, ans+"3");
    }
    public static int countPaths(int n, String ans){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            count++;
            return 1;
        }
        int a = countPaths(n-1, ans+"1");
        int b = countPaths(n-2, ans+"2");
        int c = countPaths(n-3, ans+"3");
        return a+b+c;
    }
}
