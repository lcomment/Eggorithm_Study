import java.io.*;
import java.util.*;

public class BOJ_21921 {
    static int count = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = NM[0];
        int M = NM[1];


        int[] data = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int sum = 0;

        for(int i=0; i<N; i++){
            while((index-i<M) && index<N){
                sum += data[index];
                index ++;
            }
            if(max == sum) count++;
            else if(max < sum){
                max = sum;
                count = 1;
            }
            sum -= data[i];
        }
        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(count);
    }
}