package July;

public class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        String s = "baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb";
        System.out.println(minimumDeletions(s));
    }

    private static int minimumDeletions(String s) {
        int countB = 0;
        int countA = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                countA = Math.min(countA + 1, countB);
            } else {
                countB++;
            }
        }
        return countA;
    }
}
