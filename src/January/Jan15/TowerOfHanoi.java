package January.Jan15;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int disks = scanner.nextInt();
        String source = "A";
        String helper = "B";
        String destination = "C";
        towerOfHanoi(disks, source, helper, destination);
    }
    public static void towerOfHanoi(int n, String source, String helper, String destination){
        if(n == 0){
            return;
        }
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Move "+ n + "th disk from "+ source + " to " + destination);
        towerOfHanoi(n-1, helper, source, destination);
    }
}