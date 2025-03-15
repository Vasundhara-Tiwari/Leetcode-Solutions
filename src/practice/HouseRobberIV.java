package practice;

public class HouseRobberIV {
    public int minCapability(int[] nums, int k){
        int n=nums.length;
        int ans=-1;
        int low=1;
        int high=(int)1e9;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int[] nums,int mid,int k){
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]<=mid){
                i+=2;
                k--;
            }
            else{
                i++;
            }
        }
        return k<=0;
    }
}
