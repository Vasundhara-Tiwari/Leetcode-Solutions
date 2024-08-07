package August;

import java.util.HashMap;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int n = 11223;
        System.out.println(numberToWords(n));
    }
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");

        return convertToString(num, map);
    }

    private static String convertToString(int num, HashMap<Integer, String> map) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return map.get(num) + " ";
        } else if (num < 100) {
            return map.get(num - num % 10) + " " + convertToString(num % 10, map);
        } else if (num < 1000) {
            return map.get(num / 100) + " Hundred " + convertToString(num % 100, map);
        } else if (num < 1000000) {
            return convertToString(num / 1000, map) + "Thousand " + convertToString(num % 1000, map);
        } else if (num < 1000000000) {
            return convertToString(num / 1000000, map) + "Million " + convertToString(num % 1000000, map);
        } else {
            return convertToString(num / 1000000000, map) + "Billion " + convertToString(num % 1000000000, map);
        }
    }
}
