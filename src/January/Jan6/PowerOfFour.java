package January.Jan6;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
    public static boolean isPowerOfFour(int n) {
        if(n == 1 || n == 4){
            return true;
        }
        if(n%4 != 0 || n == 0){
            return false;
        }
        return isPowerOfFour(n/4);
    }
}
