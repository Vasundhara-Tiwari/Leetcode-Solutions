package January.Jan16;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
    public static boolean rotateString(String s, String goal) {
        String str=goal+goal;
        if(s.length()!=goal.length())
            return false;
        return (str.contains(s));
    }
}
