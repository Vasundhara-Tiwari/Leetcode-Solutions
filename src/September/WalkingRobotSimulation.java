package September;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        System.out.println(robotSim(commands, obstacles));
    }
    public static int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dir = 0;
        int maxD = 0;
        Set<String> obstacle = new HashSet<>();
        for(int[] obs: obstacles){
            obstacle.add(obs[0]+", "+obs[1]);
        }
        for(int command: commands){
            if(command == -1){
                dir = (dir + 1) % 4;
            } else if (command == -2){
                dir = (dir + 3) % 4;
            } else {
                for(int move = 0; move < command; move++){
                    int nextX = x + directions[dir][0];
                    int nextY = y + directions[dir][1];
                    if(!obstacle.contains(nextX+", "+nextY)){
                        x = nextX;
                        y = nextY;
                        maxD = Math.max(maxD, x*x + y*y);
                    } else{
                        break;
                    }
                }
            }
        }
        return maxD;
    }
}
