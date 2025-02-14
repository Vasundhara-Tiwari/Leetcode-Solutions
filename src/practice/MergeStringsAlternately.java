package practice;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int n1 = word1.length();
        int n2 = word2.length();
        int i = 0;
        int j = 0;
        while(i < n1 && j < n2){
            ans += word1.charAt(i);
            ans += word2.charAt(j);
            i++;
            j++;
        }
        while(j < n2){
            ans += word2.charAt(j);
            j++;
        }
        while(i < n1){
            ans += word1.charAt(i);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeStringsAlternately msa = new MergeStringsAlternately();
        System.out.println(msa.mergeAlternately("abc", "pqrst"));
    }
}
