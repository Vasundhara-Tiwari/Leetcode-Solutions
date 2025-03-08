package practice;

public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int wc = 0, ans = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.length(); i++){
            char ch = blocks.charAt(i);
            if(ch == 'W') wc++;
            if(i < (k - 1)) continue;
            ans = Math.min(ans, wc);
            if(blocks.charAt(i - (k - 1)) == 'W')
                wc--;
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumRecolors mr = new MinimumRecolors();
        int k = 7;
        String blocks = "WBBWWBBWBW";
        System.out.println(mr.minimumRecolors(blocks, k));
    }
}
