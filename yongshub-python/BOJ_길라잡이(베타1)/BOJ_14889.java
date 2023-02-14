import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[] visit;

    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visit = new boolean[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combinations(0, 0);
        System.out.println(Min);

    }
    static void combinations(int idx, int count) {
        if(count == N / 2) {

            diff();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combinations(i + 1, count + 1);	
                visit[i] = false;	
            }
        }
    }

    static void diff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    startTeam += graph[i][j];
                    startTeam += graph[j][i];
                }
                else if (visit[i] == false && visit[j] == false) {
                    linkTeam += graph[i][j];
                    linkTeam += graph[j][i];
                }
            }
        }
        int val = Math.abs(startTeam - linkTeam);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);

    }
}