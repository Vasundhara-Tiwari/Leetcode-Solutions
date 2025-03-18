package practice;

public class ClosestPrimes {
    int[] result = {-1, -1};
    int temp = Integer.MAX_VALUE;
    int prev = 0;
    public void calculate(int number) {
        if(number <= 1) return;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return;
        }
        if(number - prev < temp && prev != 0){
            temp = number - prev;
            result[0] = prev;
            result[1] = number;
        }
        prev = number;
    }
    public int[] closestPrimes(int left, int right) {
        for(int i = left; i <= right; i++){
            calculate(i);
            if(temp <= 2) return result; 
        }
        return result;
    }
}
