package January.Jan6;

public class CalculatePower {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println(calculatePower(a, b));
    }
    public static int calculatePower(int a, int b){
        if(b == 1){
            return a;
        }
        return a*calculatePower(a, b-1);
    }
}
