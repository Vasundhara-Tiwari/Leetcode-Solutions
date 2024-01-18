package January.Jan18;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }
    public static int hammingWeight(int n) {
        String binaryRepresentation = Integer.toBinaryString(n);
        return (int) binaryRepresentation.chars().filter(c -> c == '1').count();
    }
}
