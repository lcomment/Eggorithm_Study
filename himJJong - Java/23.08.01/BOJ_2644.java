import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BOJ_2644 {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int answer = -1;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] find = br.readLine().split(" ");

        int vertex = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=0; i<=N ; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<vertex; i++){
            String[] tmp = br.readLine().split(" ");

            list.get(Integer.parseInt(tmp[0])).add(Integer.parseInt(tmp[1]));
            list.get(Integer.parseInt(tmp[1])).add(Integer.parseInt(tmp[0]));
        }

        dfs(Integer.parseInt(find[0]), Integer.parseInt(find[1]), 0);
        System.out.println(answer);
    }

    private static void dfs(int pos, int find, int cnt) {
        visited[pos] = true;

        for (int i : list.get(pos)) {
            if (!visited[i]) {
                if (i == find) {
                    answer = cnt + 1;
                }
                dfs(i, find, cnt + 1);
            }
        }
    }
}
