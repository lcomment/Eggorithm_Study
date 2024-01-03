import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited = new boolean[1000001];
        visited[0] = true;
        visited[1] = true;

        for(int i=2; i*i<=1000001; i++){
            if(!visited[i]){
                for(int j=i*i; j<1000001  ; j+=i){
                    visited[j] = true;
                }
            }
        }
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0)  break;
            boolean flag = false;
            for(int i=3; i<N; i++){
                if(!visited[i] && !visited[N-i] && i % 2 == 1 && (N-i) % 2 == 1){
                    flag = true;
                    System.out.println(N + " = " + i + " + " + (N-i));
                    break;
                }
            }
            if(!flag){
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
