package July;

public class O1Knapsack {
    public static void main(String[] args) {
        int[] items = {8, 4, 0, 5, 3};
        int[] weight = {1, 2, 3, 2, 2};
        int cap = 4;
        System.out.println(Knapsack(weight, items, cap, 0));
    }
    public static int Knapsack(int[] wt, int[] val, int cap, int i){
        if(cap == 0 || i == wt.length){
            return 0;
        }
        int inc = 0, exc = 0;
        if(cap >= wt[i]){
            inc = val[i] + Knapsack(wt, val, cap - wt[i], i+1);
        }
        exc =  Knapsack(wt, val, cap, i+1);
        return Math.max(inc, exc);
    }
}
