package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_1863 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, count = 0;
    static Stack<Point> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];

            if(y == 0){
                count += stack.size();
                while(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }

            if(stack.isEmpty() || y > stack.peek().y) {
                stack.push(new Point(x, y));
                continue;
            }

            while(!stack.isEmpty() && y < stack.peek().y){
                stack.pop();
                count++;
            }

            if(stack.isEmpty() || y != stack.peek().y){
                stack.push(new Point(x, y));
            }
        }

        count += stack.size();
        System.out.println(count);
    }
}
