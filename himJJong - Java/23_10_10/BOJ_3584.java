import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3584 {
    static int[] parent;
    static boolean[] visited;
    int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            visited = new boolean[N+1];

            while(N -- >1){
                String[] tmp = br.readLine().split(" ");
                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);
                parent[b] = a;
            }
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find(a,b);
        }
    }

    private static void find(int a, int b) {
        while(a > 0){
            visited[a] = true;
            a = parent[a];
        }

        while(b > 0){
            if(visited[b]){
                System.out.println(b);
                break;
            }
            b = parent[b];
        }
    }


}
