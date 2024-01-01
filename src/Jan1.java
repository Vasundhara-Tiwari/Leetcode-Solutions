import java.util.Arrays;

public class Jan1 {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1 < g.length && pointer2 < s.length){
            if(g[pointer1] <= s[pointer2]){
                count++;
                pointer1++;
                pointer2++;
            }
            else{
                pointer2++;
            }
        }
        return count;
    }
}
