import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16956 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int R;
    static int C;
    static String[][] data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int cnt = 0;

        data = new String[R][C];

        for (int i = 0; i < R; i++){
            data[i] = br.readLine().split("");
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(data[i][j].equals("W"))  {
                    fill(i,j);
                    cnt++;
                }
            }
        }

        if(cnt==0){
            System.out.println(1);
            Loop:
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(data[i][j].equals("."))    {
                        data[i][j] = "D";
                        break Loop;
                    }
                }
            }
            stoBuilder();
            System.out.println(sb);
            System.exit(0);
        }
        System.out.println(1);
        stoBuilder();
        System.out.println(sb);
    }

    private static void stoBuilder() {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(data[i][j]);
            }
            sb.append("\n");
        }
    }

    private static void fill(int x, int y) {
        for(int i=0; i<4; i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if(moveX >=0 && moveY >=0 && moveX < R && moveY < C && data[moveX][moveY].equals("S")){
                System.out.println(0);
                System.exit(0);
            }
            if(moveX >=0 && moveY >=0 && moveX < R && moveY < C && data[moveX][moveY].equals(".")){
                data[moveX][moveY] = "D";
            }
        }
    }
}
