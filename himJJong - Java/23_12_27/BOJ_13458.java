import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13458 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long count = 0;

        for(int i=0; i<N; i++){
            data[i] -= B;
            count++;
        }

        for(int i=0; i<N; i++){
            if(data[i] <= 0)    continue;
            count += data[i] / C;
            if(data[i] % C != 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
