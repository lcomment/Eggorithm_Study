import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1068{
    static int[] parent;
    static int count = 0;
    static int N;
    static int root;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        visited = new boolean[N];

        String[] data = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            parent[i] = Integer.parseInt(data[i]);
            if(parent[i] == -1) root = i;
        }

        int delete = Integer.parseInt(br.readLine());

        deleteNode(delete);
        count = 0;
        countLeaf();

        System.out.println(count);
    }

    private static int countLeaf() {
        int sum = 0;

        for(int i=0; i<N; i++){
            if(visited[i])  continue;

            if(isLeaf(i))   count++;
        }
        return sum;
    }

    private static boolean isLeaf(int idx) {
        visited[idx] = true;

        boolean leaf = true;
        for(int i=0; i<N; i++){
            if(parent[i] == idx){
                leaf = false;
                break;
            }
        }
        return leaf;
    }

    private static void deleteNode(int delete) {
        parent[delete] = -2;
        visited[delete] = true;

        for(int i=0; i<N; i++){
            if(parent[i] == delete){
                deleteNode(i);
            }
        }
    }
}