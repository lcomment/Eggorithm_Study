import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BOJ_2623 {
    static int N;
    static int M;
    static List<Integer>[] list;
    static int[] degree;
    static Queue<Integer> processQ = new LinkedList<>();
    static Queue<Integer> result = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        degree = new int[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] tmp = br.readLine().split(" ");
            if(tmp.length == 2) continue;
            for(int j=0; j<Integer.parseInt(tmp[0])-1; j++){
                int a = Integer.parseInt(tmp[j+1]);
                int b = Integer.parseInt(tmp[j+2]);

                list[a].add(b);
                degree[b]++;
            }
        }

        topologicalSort();
        if(result.size() != N){
            System.out.println(0);
            System.exit(0);
        }
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }

    private static void topologicalSort() {
        for(int i=1; i<=N; i++){
            if(degree[i] == 0){
                processQ.add(i);
            }
        }

        while(!processQ.isEmpty()){
            int tmp = processQ.poll();
            result.add(tmp);

            for(int k : list[tmp]){
                degree[k]--;
                if(degree[k] == 0){
                    processQ.add(k);
                }
            }
        }
    }
}
