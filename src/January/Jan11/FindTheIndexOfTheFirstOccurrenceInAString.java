package January.Jan11;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        int left = 0, right = needle.length();
        while(right <= haystack.length()) {
            if (haystack.substring(left, right).equals(needle))
                return left;
            else {
                left++;
                right++;
            }
        }
        return -1;
    }
}
