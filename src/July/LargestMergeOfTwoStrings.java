package July;

public class LargestMergeOfTwoStrings {
    public static void main(String[] args) {
        String word1 = "abcabc ", word2 = "abdcaba";
        String ans = "";
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()){
            if(word1.substring(i).compareTo(word2.substring(j)) > 0){
                ans += word1.charAt(i);
                i++;
            } else {
                ans += word2.charAt(j);
                j++;
            }
        }
        while (i < word1.length()){
            ans+=word1.charAt(i);
            i++;
        }
        while (j < word2.length()){
            ans+= word2.charAt(j);
            j++;
        }
        System.out.println(ans);
    }
}