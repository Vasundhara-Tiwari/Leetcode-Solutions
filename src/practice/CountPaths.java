package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CountPaths {
    boolean []visited;
    int lastNode;
    int mod= 1000000007;
    public int countPaths(int n, int[][] roads) {
        if(n==1){
            return 1;
        }

        lastNode= n;

        List<List<int[]>> adjList= new ArrayList<>();

        visited= new boolean[n];

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        int[] inDegree= new int[n];

        for(int [] road: roads){
            inDegree[road[0]]++;
            inDegree[road[1]]++;
            adjList.get(road[0]).add(new int[]{road[1], road[2]});
            adjList.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<int[]> roadLists= new PriorityQueue<>((arr1, arr2)->arr1[1]-arr2[1]);

        roadLists.add(new int[]{0, 0});

        int []countPath= new int[n];
        int []maxAmountPath= new int[n];
        Arrays.fill(maxAmountPath, Integer.MAX_VALUE);
        Arrays.fill(countPath, 1);

        int maxAmount= Integer.MAX_VALUE;
        int count= 0;

        while(!roadLists.isEmpty()){
            int []root= roadLists.remove();

            int city= root[0];
            int amount= root[1];

            if(visited[city]){
                continue;
            }

            visited[city]= true;

            for(int []val: adjList.get(city)){
                int curCity= val[0];
                int curAmount= val[1];
                if(curCity==n-1){
                    if(maxAmount>0 && maxAmount == curAmount+amount){
                        count= (count+countPath[city])%mod;
                    }else if(maxAmount>curAmount+amount){
                        maxAmount= curAmount+amount;
                        count= countPath[city];
                    }
                    continue;
                }
                if(visited[curCity]){
                    continue;
                }
                if(maxAmountPath[curCity] == curAmount+amount){
                    countPath[curCity]= (countPath[curCity]+countPath[city])%mod;
                }else if(maxAmountPath[curCity]>curAmount+amount){
                    maxAmountPath[curCity]= curAmount+amount;
                    countPath[curCity]= countPath[city];
                }
                roadLists.add(new int[]{curCity, curAmount+amount});
            }
        }
        return count;
    }
}
