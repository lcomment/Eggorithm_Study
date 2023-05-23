import java.io.*;
import java.util.*;

public class BOJ_2252 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCount = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            edgeCount[y]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=1; i<=N; i++){
            if(edgeCount[i] == 0)   q.add(i);
        }

        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            int cur = q.poll();

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                edgeCount[next]--;
                if(edgeCount[next] == 0)    q.add(next);
            }
        }

    }
}