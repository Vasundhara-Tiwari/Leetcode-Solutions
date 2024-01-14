package January.Jan13;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int nums = 3;
        List<String> al = new ArrayList<>();
        generateAllCombinations(nums, 0, 0, "", al);
        System.out.println(al);
    }
    public static void generateAllCombinations(int num, int left, int right, String str, List<String> al){
        if(left == num && right == num){
            al.add(str);
            return;
        }
        if(left < num){
            generateAllCombinations(num, left + 1, right, str + "(", al);
        }
        if(right < left){
            generateAllCombinations(num, left, right + 1, str + ")", al);
        }
    }
}
