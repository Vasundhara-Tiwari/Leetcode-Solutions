package September;

public class PaintThePlank {
    /*
we have plank
width of each is 1m
height is [1, 2, 3]
brush width - 1m

[2, 2, 1, 2, 1]
output -> 3

horizontal ->
  1-> [1, 1, 0, 1, 0]
  2-> [0, 0, 0, 1, 0]
  3-> [0, 0, 0, 0, 0]

vertical ->
  1 -> [0, 2, 1, 2, 1]
  2 -> [0, 0, 1, 2, 1]
  3 -> [0, 0, 0, 2, 1]
  4 -> [0, 0, 0, 0, 1]
  5 -> [0, 0, 0, 0, 0]

  */

/* choice 0 -> horizontal
choice 1 -> vertical
*/

    public static int countStrokes(int[] height){

        int horizontal = find(height, 0, 0);
        int vertical = find(height, 1, 0);
        return Math.min(horizontal, vertical);
    }

//[3, 0, 1, 1, 0, 0, 2, 2]
//
//        [2, 0, 1, 1, 0, 0, 2, 2]
//
//        [2, 0, 0, 0, 0, 0, 2, 2]
//
//        [2, 0, 0, 0, 0, 0, 0, 0]
//
//        [1, 0, 0, 0, 0, 0, 0, 0]
//
//        [0, 0, 0, 0, 0, 0, 0, 0]

    public static int find(int[] height, int choice, int index){
        if(index >= height.length){
            if(checkAllZeroes(height) != height.length){
                index = checkAllZeroes(height);
            } else {
                return 0;
            }
        }
        if(choice == 0){
            for(int i = index; i < height.length; i++){
                if(height[i] == 0){
                    while(index < height.length && height[index] == 0){
                        index++;
                    }
                    break;
                }
                if(height[i] > 0){
                    height[i]--;
                }
            }
        }
        if(choice == 1){
            while(index < height.length && height[index] == 0){
                index++;
            }
            height[index] = 0;
        }
        int h = find(height, 0, index);
        int v = find(height, 1, index);
        return Math.min(h, v) + 1;
    }

    public static int checkAllZeroes(int[] height){
        for(int i = 0; i < height.length; i++){
            if(height[i] != 0){
                return i;
            }
        }
        return height.length;
    }

    public static void main(String[] args) {
        int[] heights = {2, 2, 1, 2, 1};
        System.out.println(countStrokes(heights));
    }

}
