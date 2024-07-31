package July;

public class FillingBookcaseShelves {
    public static void main(String[] args) {
        int[][] books = {{1, 1}, {2,3}, {2,3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth = 4;
        int[][] dp = new int[books.length+1][shelfWidth+1];
        System.out.println(minHeight(books, shelfWidth, 0, 0, 0, dp));
    }

    private static int minHeight(int[][] books, int shelfWidth, int height, int width, int index, int[][] dp) {
        if (index == books.length){
            return height;
        }
        if (dp[index][width] != 0){
            return dp[index][width];
        }
        int takeHeight = Integer.MAX_VALUE;
        int noTakeHeight = Integer.MAX_VALUE;
        if(books[index][0]+width <= shelfWidth){
            takeHeight = minHeight(books, shelfWidth, Math.max(books[index][1], height), books[index][0]+width, index+1, dp);
        }
        noTakeHeight = height + minHeight(books, shelfWidth, books[index][1], books[index][0], index+1, dp);
        return dp[index][width] = Math.min(takeHeight, noTakeHeight);
    }
}
