import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976{
    static int[] parent;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1)    union(i,j);
            }
        }

        st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        for(int i=1; i<M; i++){
            int k = Integer.parseInt(st.nextToken());
            if(parent[first] != parent[k]){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    private static void union(int x, int b) {
        int findA = findParent(x);
        int findB = findParent(b);

        if(findA != findB){
            if(findA > findB){
                parent[findA] = findB;
            }
            else{
                parent[findB] = findA;
            }
        }
    }

    private static int findParent(int b) {
        if(b == parent[b]){
            return b;
        }
        return parent[b] = findParent(parent[b]);
    }
}