package June;

public class StringPermutation {
    public static void main(String[] args) {
        String str = "abc";
        printAllPermutations(str, "");
    }

    private static void printAllPermutations(String str, String ans) {
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(0);
            String s1 = str.substring(0, i);
            String s2 = str.substring(i+1);
            printAllPermutations(s1+s2, ans+ch);
        }
    }
}
