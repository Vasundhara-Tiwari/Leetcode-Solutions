package July;

public class JumpGameII {
    static int step = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jumps(nums, 0, 0));
        System.out.println(step);
    }

    private static int jumps(int[] nums, int i, int steps) {
        if(i >= nums.length-1){
            return steps;
        }
        for (int idx = i; idx < nums.length; idx++){
            steps = jumps(nums, i+nums[i], steps+1);
        }
        System.out.println(steps);
        return step = Math.min(step, steps);
    }

}
