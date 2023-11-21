import java.io.*;
import java.util.*;

class Swea_corp{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= test; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            int[][] data = new int[N][N];

            for(int i=0; i<N; i++) {
                data[i] = Arrays.stream(br.readLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            for(int i=0; i<N; i++) {
                sum += data[N/2][i];
            }

            for(int i=0; i<N/2; i++) {
                for(int j=N/2 - i; j <= N/2 + i; j++) {
                    sum += data[i][j];
                }
            }

            for(int i=N-1; i>N/2; i--) {
                for(int j=N/2 - (N-i-1); j <= N/2 + (N -i-1); j++) {
                    sum += data[i][j];
                }
            }
            System.out.println("#"+test_case+" "+sum);
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