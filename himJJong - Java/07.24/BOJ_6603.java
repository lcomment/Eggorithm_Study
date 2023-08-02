import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static int N;
    static int[] data;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N==0){
                System.out.println(sb);
                break;
            }

            data = new int[N];
            answer = new int[6];

            for(int i=0; i<N; i++){
                data[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);
            sb.append("\n");
        }
    }

    private static void backTracking(int count, int at) {
        if(count == 6){
            for(int i=0; i<answer.length; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<N; i++){
            if(count==0)    {
                answer[count] = data[i];
                backTracking(count+1, i+1);
                answer[count]=0;
            }
            else if(count >= 1 && answer[count-1] < data[i]){
                answer[count] = data[i];
                backTracking(count+1, i+1);
                answer[count] = 0;
            }
        }
    }
}
