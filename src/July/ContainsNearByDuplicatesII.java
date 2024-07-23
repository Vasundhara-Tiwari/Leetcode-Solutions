package July;

public class ContainsNearByDuplicatesII {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,2,5};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            } else {
                int idx = map.get(nums[i]);
                if(Math.abs(i-idx) <= k){
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
