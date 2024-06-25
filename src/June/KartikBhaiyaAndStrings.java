package June;

// Question Link - https://codeskiller.codingblocks.com/problems/446
public class KartikBhaiyaAndStrings {
    public static void main(String[] args) {
        String str = "abba";
        int k = 2;
        int flipA = maxLength(str, k, 'a');
        int flipB = maxLength(str, k, 'b');
        System.out.println(Math.max(flipA, flipB));
    }
//    public static int maxLength(String str, int k, char ch){
//        int startIndex = 0;
//        int endIndex = 0;
//        int length = 0;
//        int ans = 0;
//        while (endIndex < str.length()){
//            if(str.charAt(endIndex) == ch){
//                length++;
//                endIndex++;
//            } else {
//                if(k > 0){
//                    length++;
//                    k--;
//                }
//            }
//            while (k <= 0 && str.charAt(endIndex) == 'b'){
//                startIndex++;
//                length--;
//            }
//        }
//        return length;
//    }
    public static int maxLength(String str, int k, char ch) {
        int si = 0;
        int ei = 0;
        int flip = 0;
        int ans = 0;
        while (ei < str.length()){
            //grow
            if(str.charAt(ei) == ch){
                flip++;
            }
            //shrink
            while (flip > k){
                if(str.charAt(si) == ch){
                    flip--;
                }
                si++;
            }
            ans = Math.max(ans, ei - si + 1);
            ei++;
        }
        return ans;
    }
}
