package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0;
        int j = 0;
        List<List<Integer>> lst = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i][0] == nums2[j][0]){
                lst.add(new ArrayList<>(Arrays.asList(nums1[i][0], nums1[i][1] + nums2[j][1])));
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]){
                lst.add(new ArrayList<>(Arrays.asList(nums1[i][0], nums1[i][1])));
                i++;
            } else {
                lst.add(new ArrayList<>(Arrays.asList(nums2[j][0], nums2[j][1])));
                j++;
            }
        }
        while(i < nums1.length){
            lst.add(new ArrayList<>(Arrays.asList(nums1[i][0], nums1[i][1])));
            i++;
        }
        while(j < nums2.length){
            lst.add(new ArrayList<>(Arrays.asList(nums2[j][0], nums2[j][1])));
            j++;
        }
        int rows = lst.size();
        int cols = lst.get(0).size();
        int[][] array = new int[rows][cols];

        for (int k = 0; k < rows; k++) {
            for (int l = 0; l < cols; l++) {
                array[k][l] = lst.get(k).get(l);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[][]  nums1 = {{1,2},{2,3},{4,5}}, nums2 = {{1,4},{3,2},{4,1}};
        MergeArrays ma = new MergeArrays();
        int[][] result = ma.mergeArrays(nums1, nums2);
        for (int[] a: result){
            System.out.println(Arrays.toString(a));
        }
    }
}
