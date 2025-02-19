package practice;

import java.util.ArrayList;
import java.util.List;

public class KthLexicalHappyString {
    List<String>res;
    void helper(char arr[], StringBuilder str, char prev, int n){
        if(str.length() == n){
            res.add(str.toString());
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] == prev) continue;
            str.append(arr[i]);
            helper(arr, str, arr[i], n);
            str.deleteCharAt(str.length()-1);
        }
    }
    public String getHappyString(int n, int k) {
        char arr[] = {'a', 'b', 'c'};
        res = new ArrayList<>();
        helper(arr, new StringBuilder(), '#', n);
        return  res.size()<k?"":res.get(k-1);
    }

    public static void main(String[] args) {
        KthLexicalHappyString kth = new KthLexicalHappyString();
        System.out.println(kth.getHappyString(3, 9));
    }
}
