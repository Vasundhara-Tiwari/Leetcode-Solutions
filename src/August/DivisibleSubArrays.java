package August;

import java.util.HashMap;
import java.util.Scanner;

public class DivisibleSubArrays {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < n; i++)
                arr[i]=scn.nextInt();
            System.out.println(subarraysDivByK(arr, n));
        }
    }
    public static long subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
                map.put(rem,map.getOrDefault(rem,0)+1);
            }else{
                map.put(rem,1);
            }
        }
        return count;
    }
}
