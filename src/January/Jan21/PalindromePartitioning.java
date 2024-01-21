package January.Jan21;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<String> al = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        partition(s, al, list);
        System.out.println(list);
    }
    public static void partition(String ques, List<String> al, List<List<String>> list){
        if(ques.length() == 0){
            list.add(new ArrayList<>(al));
            return;
        }
        for(int i = 1; i <= ques.length(); i++){
            String s = ques.substring(0, i);
            if(isPalindrome(s)){
                al.add(s);
                partition(ques.substring(i), al, list);
                al.remove(al.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
