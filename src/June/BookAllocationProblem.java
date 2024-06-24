package June;

public class BookAllocationProblem {
    // Question Link - https://codeskiller.codingblocks.com/problems/1365
    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int students = 2;
        System.out.println(minPages(pages, students));
    }

    private static int minPages(int[] pages, int students) {
        int low = 0;
        int high = 0;
        for(int i = 0; i < pages.length; i++){
            high += pages[i];
        }
        int ans = 0;
        while (low <= high){
            int mid = (low + high)/2;
            if(isItPossible(pages, students, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isItPossible(int[] pages, int students, int mid) {
        int pageRead = 0;
        int student = 1;
        for(int i = 0; i < pages.length;){
            if(pages[i] + pageRead <= mid){
                pageRead += pages[i];
                i++;
            } else {
                student++;
                pageRead = 0;
            }
            if(students < student){
                return false;
            }
        }
        return true;
    }

}
