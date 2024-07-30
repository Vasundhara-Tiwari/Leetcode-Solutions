package July;

import java.util.*;
import java.util.HashMap;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int[] i : prerequisites){
            int v1 = i[0];
            int v2 = i[1];
            if(!map.containsKey(v1)){
                map.put(v1, new HashMap<>());
            }
            map.get(v1).put(v2, 0);
        }
        int[] indegree = new int[numCourses];
        for(int e1: map.keySet()){
            for(int e2: map.get(e1).keySet()){
                indegree[e2]++;
            }
        }
        System.out.println(Arrays.toString(indegree));
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int val = q.remove();
            ans.add(val);
            if(map.get(val) != null){
                for(int e1: map.get(val).keySet()){
                    indegree[e1]--;
                    if(indegree[e1] == 0){
                        q.add(e1);
                    }
                }
            }
        }
        if(ans.size() != numCourses){
            return new int[0];
        }
        int[] res = new int[ans.size()];
        int j = 0;
        for(int i = ans.size()-1; i >= 0; i--){
            res[j] = ans.get(i);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        int numCourses = 3;
        int[][] prerequisites = {{0, 2}, {1, 2}, {2, 0}};
        System.out.println(Arrays.toString(cs.findOrder(numCourses, prerequisites)));
    }
}
