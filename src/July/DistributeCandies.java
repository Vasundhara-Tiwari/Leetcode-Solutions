package July;

import java.util.HashSet;

public class DistributeCandies {
    public static void main(String[] args) {
        int[] arr ={1,1,2,2,3,3};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        if(set.size() >= arr.length / 2){
            System.out.println(arr.length/2);
        } else {
            System.out.println(set.size());
        }
    }
}
