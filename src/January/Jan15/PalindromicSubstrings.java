package January.Jan15;

import java.util.ArrayList;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
        System.out.println(countPalindromicSubstrings(s));
    }
    public static int countSubstrings(String s) {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < s.length();  i++){
            for(int j = i+1; j <= s.length(); j++){
                String str = s.substring(i, j);
                if(isPalindrome(str)){
                    al.add(str);
                }
            }
        }
        return al.size();
    }
    static boolean isPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }

    //Approach 2
    public static int countPalindromicSubstrings(String str){
        int odd = 0;
        for(int axis = 0; axis < str.length(); axis++){
            for(int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++){
                if(str.charAt(axis - orbit) != str.charAt(axis + orbit)){
                    break;
                }
                odd++;
            }
        }
        int even = 0;
        for(double axis = 0.5; axis < str.length(); axis++){
            for(double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++){
                if(str.charAt((int)(axis - orbit)) != str.charAt((int)(axis + orbit))){
                    break;
                }
                even++;
            }
        }
        return odd + even;
    }
}
