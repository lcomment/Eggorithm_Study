package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class BOJ_8911 {
    static int T;
    static int direction,x,y;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxX,minX,maxY,minY;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            char[] testcase = br.readLine().toCharArray();
            
            direction = 0;
            x = 0;
            y = 0;
            maxX = 0;
            maxY = 0;
            minX = 0;
            minY = 0;
            
            for (int i = 0; i < testcase.length; i++) {
                switch(testcase[i]) {
	                case 'F':
	                    x += dx[direction];
	                    y += dy[direction];
	                    move();
	                    break;
	                case 'B':
	                    x -= dx[direction];
	                    y -= dy[direction];
	                    move();
	                    break;
	                case 'L':
	                	direction = (direction - 1 == -1) ? 3 : direction - 1;
	                    break;
	                case 'R':
	                	direction = (direction + 1 == 4) ? 0 : direction + 1;
	                    break;
	                }
            }
            System.out.println(Math.abs(maxX - minX) * Math.abs(maxY - minY));
        }
    }
    
    static void move() {
        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        minY = Math.min(minY, y);
    }
 
}
