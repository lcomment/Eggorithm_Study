import java.util.*;
import java.io.*;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[][] initialize = new int[2][count];

        for(int i=0 ; i<2 ; i++) {
            initialize[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(initialize[i]);
        }

        int answer = 0;
        
        for(int i=0; i<count ; i++){
            answer += initialize[0][i] * initialize[1][count-(i+1)];
        }

        System.out.println(answer);
    }
}
