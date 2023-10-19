import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11404 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dist = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = 987654321;
                }
            }
        }

        for(int i=0; i<M; i++){
            String[] tmp = br.readLine().split(" ");

            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1 ; j<=N; j++){
                if(dist[i][j] == 987654321) System.out.print(0+" ");
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
}
