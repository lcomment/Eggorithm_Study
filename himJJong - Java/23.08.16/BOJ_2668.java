import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668 {
    static List<Integer> list;
    static boolean[] visited;
    static int[] data;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        data = new int[N+1];

        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    private static void dfs(int from, int to) {
        if(!visited[data[from]]){
            visited[data[from]] = true;
            dfs(data[from], to);
            visited[data[from]] = false;
        }
        if(data[from] == to)    list.add(to);
    }
}
