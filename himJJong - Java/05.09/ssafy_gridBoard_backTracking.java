import java.io.*;
import java.util.*;

class ssafy_gridBoard_backTracking
{
    static int[][] data;
    static String[]	result;
    static int answer;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static HashSet<String> set;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            data = new int[4][4];
            result = new String[7];
            answer = 0;
            set = new HashSet<>();

            for(int i=0; i<4 ; i++){
                data[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            for( int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    backTracking(i,j,1,String.valueOf(data[i][j]));
                }
            }
            System.out.println("#"+test_case+" "+set.size());
        }
    }

    static void backTracking(int x, int y, int depth,String tmp){
        if(depth==7){
            set.add(tmp);
            return;
        }

        for(int i=0; i<4; i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if(moveX >=0 && moveX < 4 && moveY >=0 && moveY < 4){
                backTracking(moveX, moveY, depth+1, tmp + String.valueOf(data[moveX][moveY]) );
            }
        }
    }
}