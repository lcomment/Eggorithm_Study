import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2252 {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] indegree;
    static int N;
    static int M;
    static Queue<Integer> resultQ = new LinkedList<>();
    static Queue<Integer> processQ = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            list.get(a).add(b);
            indegree[b]++;
        }

        topologicalSort();

        while(!resultQ.isEmpty()){
            System.out.print(resultQ.poll()+" ");
        }
    }

    private static void topologicalSort() {
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0){
                processQ.add(i);
            }
        }

        while(!processQ.isEmpty()){
            int tmp = processQ.poll();
            resultQ.add(tmp);
            for(int k : list.get(tmp)){
                indegree[k]--;
                if(indegree[k] == 0){
                    processQ.add(k);
                }
            }
        }
    }
}
