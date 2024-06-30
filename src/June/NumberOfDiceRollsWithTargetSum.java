package June;

public class NumberOfDiceRollsWithTargetSum {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 4, 7));
    }
    public static int numRollsToTarget(int n, int k, int target) {
        findAllCombinations(4, 0, "");
        return count;
    }
    public static void findAllCombinations(int target, int current, String ans){
        if(target == current){
            System.out.println(ans);
            count++;
            return;
        }
        if(current > target){
            return;
        }
        for(int dice = 1; dice <= 3; dice++){
            findAllCombinations(target, current+ dice, ans+dice);
        }

    }
}
