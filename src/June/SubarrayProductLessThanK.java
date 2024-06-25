package June;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int product = 1;
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex < nums.length){
            product *= nums[endIndex];
            while (product >= k && startIndex <= endIndex){
                product = product / nums[startIndex];
                startIndex++;
            }
            count+=(endIndex-startIndex)+1;
            endIndex++;
        }
        return count;
    }

//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        if(k==0 || k==1){
//            return 0;
//        }
//        int ans=0;
//        int l=0;
//        int count=1;
//        int r=1;
//        int prod=nums[0];
//        int n = nums.length;
//        while(r<=n && l<n){
//            // System.out.println("r "+r+" l "+l+" p "+prod+" c "+ count +" a "+ans);
//            if(prod<k){
//                ans+=count;
//                if(r<n){
//                    prod*=nums[r];
//                }
//                count++;
//                r++;
//            }
//            else{
//                prod=prod/nums[l];
//                l++;
//                count--;
//            }
//        }
//        return ans;
//    }
}
