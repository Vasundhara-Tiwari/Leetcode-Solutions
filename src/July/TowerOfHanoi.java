package July;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        TOH(n, "A", "C", "B");
    }
    public static void TOH(int n, String source, String helper, String destination){
        if(n == 0){
            return;
        }
        TOH(n-1, source, destination, helper);
        System.out.println("move " + n + "th disk from " + source + " to " + destination);
        TOH(n-1, helper, source , destination);
    }
}
