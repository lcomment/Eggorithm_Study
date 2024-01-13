import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22862 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int limit = K;
        int answer = Integer.MIN_VALUE;

        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if(N == 1){
            if(data[0] % 2 == 1){
                System.out.println(0);
            }
            else{
                System.out.println(1);
            }
            System.exit(0);
        }
        int left = 0;
        int right = 0;
        boolean flag = false;
        for(int i=0; i<N; i++){
            if(data[i] % 2 == 0){
                left = i;
                right = i+1;
                answer = 1;
                flag = true;
                break;
            }
        }
        if(!flag)   {
            System.out.println(0);
            System.exit(0);
        }
        int count = 1;
        while(right < N){
            if(data[right] % 2 == 1){
                K--;
            }
            else{
                count++;
            }
            if(K>=0){
                answer = Math.max(answer, count);
                right++;
            }
            else{
                while(K<0){
                    if(data[left] % 2 == 0){
                        count--;
                    }
                    else{
                        K++;
                    }
                    left++;
                }
                right++;
            }
        }

        if(answer == Integer.MIN_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(answer);
        }
    }
}
