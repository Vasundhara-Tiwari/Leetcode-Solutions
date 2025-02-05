package DailyCodingProblem;

public class Question1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 != n2){
            return false;
        }
        int count = 0;
        int first = -1;
        int second = -1;
        for(int i = 0; i < n1; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count == 1){
                    first = i;
                } else if(count == 2){
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }

    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        Question1790 q = new Question1790();
        System.out.println(q.areAlmostEqual(s1, s2));
    }
}
