import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOJ_16938 {
    static int NM[];
    static int[] data;
    static int count;
    static boolean[] flag;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        flag = new boolean[NM[0]];

        for(int i=2; i<=NM[0]; i++){
            findAnswer(0,0,i);    // depth 한계, 시작점, 증가 depth
        }
        System.out.println(count);
    }

    private static void findAnswer(int at, int depth, int findProblem) {
        if(depth == findProblem){
            count += check();
            return;
        }
        for(int i = at; i<NM[0]; i++){
            flag[i] = true;
            findAnswer(i+1,depth+1,findProblem);
            flag[i] = false;
        }
    }
    private static int check() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<NM[0]; i++){
            if(flag[i]){
                sum+=data[i];
                if(max<data[i]) max = data[i];
                if(min>data[i]) min = data[i];
            }
        }

        if(sum >= NM[1] && sum <= NM[2] && NM[3] <= max - min){
            return 1;
        }
        return 0;
    }
}