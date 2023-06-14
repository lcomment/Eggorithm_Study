import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        for(int i=0; i<test_case ; i++){
            long answer = 0;
            int data = Integer.parseInt(br.readLine());
            int[] input = new int[data];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<data; j++){
                input[j] = Integer.parseInt(st.nextToken());
            }

            int big = input[data-1];

            for(int j=data-2; j>=0; j--){
                if(input[j] > big)  big = input[j];
                else answer += big-input[j];
            }
            System.out.println(answer);
        }
    }
}
