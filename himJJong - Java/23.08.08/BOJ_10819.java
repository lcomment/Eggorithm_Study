import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {
    static int[] answer;
    static boolean[] visited;
    static int[] data;
    static int max = Integer.MIN_VALUE;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new int[N];
        answer = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);
        System.out.println(max);
    }

    private static void backTracking(int count) {
        if(count == N){
            int sum = 0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(answer[i] - answer[i+1]);
            }
            max = Math.max(max,sum);
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[count] = data[i];
                backTracking(count+1);
                answer[count] = 0;
                visited[i] = false;
            }
        }
    }
}
