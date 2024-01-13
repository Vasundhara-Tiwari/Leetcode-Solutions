package January.Jan13;

public class GenerateParentheses {
    public static void main(String[] args) {
        int nums = 3;
        List<String> al = new ArrayList<>();
        generateAllCombination(n, 0, 0, "", al);
        System.out.println(al);
    }
    public static void generateAllCombination(int num, int left, int right, String str, List<String> al){
        if(left == num && right == num){
            al.add(str);
            return;
        }
        if(left < num){
            generateAllCombination(num, left + 1, right, str + "(", al);
        }
        if(right < left){
            generateAllCombination(num, left, right + 1, str + ")", al);
        }
    }
}
