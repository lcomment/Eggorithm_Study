import java.util.*;
import java.io.*;

public class BOJ_1476 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        int[] init = {1,1,1};
        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // E 1~15, S 1~28, M 1~19

        while(init[0]!=NM[0] || init[1]!=NM[1] || init[2] != NM[2]){
            init[0]++;
            init[1]++;
            init[2]++;
            if(init[0]>15) init[0] = 1;
            if(init[1]>28) init[1] = 1;
            if(init[2]>19) init[2] = 1;
            count++;
        }
        System.out.println(count);
    }
}
