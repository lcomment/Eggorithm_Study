import java.util.*;
import java.io.*;

class pro_keypadPush {
    static class Hand{
        int x;
        int y;
        Hand(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] data;
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        data = new int[4][3];
        int num = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                data[i][j] = num;
                num++;
            }
        }
        data[3][1] = 0;
        data[3][0] = 10;
        data[3][2] = 10;
        Hand left = new Hand(3,0);
        Hand right = new Hand(3,2);

        for(int i=0; i<numbers.length; i++){
            Hand check = check(numbers[i]);
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                Hand tmp = check(numbers[i]);
                left = new Hand(tmp.x, tmp.y);
                continue;
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                Hand tmp = check(numbers[i]);
                right = new Hand(tmp.x, tmp.y);
                continue;
            }

            int leftCompare = Math.abs(check.x - left.x) + Math.abs(check.y - left.y);
            int rightCompare = Math.abs(check.x - right.x) + Math.abs(check.y - right.y);

            if(leftCompare < rightCompare){
                sb.append("L");
                left = new Hand(check.x, check.y);
            }
            else if(leftCompare > rightCompare){
                sb.append("R");
                right = new Hand(check.x, check.y);
            }
            else{
                if(hand.equals("right")){
                    sb.append("R");
                    right = new Hand(check.x, check.y);
                }
                else{
                    sb.append("L");
                    left = new Hand(check.x, check.y);
                }
            }
        }
        return sb.toString();
    }
    private static Hand check(int val){
        Hand result = new Hand(0,0);
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(val == data[i][j]){
                    result = new Hand(i,j);
                    break;
                }
            }
        }
        return result;
    }
}