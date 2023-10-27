import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2096 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int right = 1;
        while(true){
            if(right * right >= N)    break;
            right++;
        }

        int left = 1;
        StringBuilder sb = new StringBuilder();
        while(left < right){
            int data = (int) (Math.pow(right,2) - Math.pow(left,2));
            if(data == N){
                sb.append(right).append("\n");
                right++;
                left++;
            }
            else if(data < N){
                right++;
            }
            else if(data > N){
                left++;
            }

            if(right - left == 1 && (Math.pow(right,2) - Math.pow(left,2)) > N)    break;
        }
        if(sb.length() == 0){
            System.out.println(-1);
        }
        else System.out.println(sb.toString());
    }
}
