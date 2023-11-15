import java.io.*;
import java.util.*;

class Swea_파리퇴치{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][];

            for(int j=0; j<N; j++) {
                map[j] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int answer = 0;
            for(int j=0; j<=N-M; j++) {
                for(int k=0; k<=N-M; k++) {
                    int cal = 0;
                    for(int l = j; l < j+M; l++) {
                        for(int h = k; h < k + M; h++) {
                            cal += map[l][h];
                        }
                    }
                    answer = Math.max(answer, cal);
                }
            }

            System.out.println("#" + i +" " + answer);
        }

    }
}

/*


1  3  3  6 7
8 13  9 12 8
4 16 11 12 6
2  4  1 23 2
9 13  4  7 3



*/