package July;


import java.util.Stack;

public class CompressionAndDecompression {
    public static void main(String[] args) {
        String s = "3[a2[b2[c]d]e]";
        int n = 0;
        Stack<StringBuilder> res = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == '['){
                indexes.push(n);
                n = 0;
                res.push(sb);
                sb = new StringBuilder();
            } else if(c == ']'){
                int idx = indexes.pop();
                StringBuilder temp = sb;
                sb = res.pop();
                while (idx > 0){
                    sb.append(temp);
                    idx--;
                }
            } else if(Character.isDigit(c)){
                n = n * 10 + (c - '0');
            } else{
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
//String str = "2[3[a]b]";
//        Stack<Character> brackets = new Stack<>();
//        Stack<Integer> nums = new Stack<>();
//        StringBuilder finalAns = new StringBuilder();
//        StringBuilder part = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            StringBuilder ans = new StringBuilder();
//            if(str.charAt(i) == '['){
//                brackets.push(str.charAt(i));
//            } else if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
//                if (!nums.isEmpty() && (str.charAt(i-1) >= 49 && str.charAt(i-1) <= 57)){
//                    int n = nums.pop();
//                    nums.push(n*10 + (int)(str.charAt(i))-48);
//                } else {
//                    nums.push((int)(str.charAt(i))-48);
//                }
//                if(brackets.isEmpty()){
//                    finalAns.append(part);
//                    part = new StringBuilder("");
//                }
//            } else if(str.charAt(i) == ']'){
//                brackets.pop();
//                int n = nums.pop();
//                for (int j = 0; j < n; j++) {
//                    ans.append(part);
//                }
//                part = ans;
//            } else{
//                part.append(str.charAt(i));
//            }
//        }
//        finalAns.append(part);
//        System.out.println(finalAns);
