import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int compare = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        int leftAnswer = 0;
        int rightAnswer = 0;


        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        int left = 0;
        int right = N-1;

        while(left < right){
            int sum = data[left] + data[right];

            if(Math.abs(sum) < compare){
                compare = sum;
                leftAnswer = data[left];
                rightAnswer = data[right];
            }

            if(sum < 0){
                left++;
            }
            else if(sum > 0){
                right--;
            }
            else{
                break;
            }
        }
        System.out.print(leftAnswer +" "+ rightAnswer);
    }
}
