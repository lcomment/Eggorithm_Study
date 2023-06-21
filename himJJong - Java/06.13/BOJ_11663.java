import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11663 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Node> chicken = new ArrayList<>();
    static List<Node> person = new ArrayList<>();
    static int[][] data;
    static boolean[] open;
    static int result = Integer.MAX_VALUE;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N][N];


        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                data[i][j] = Integer.parseInt(tmp[j]);
                if(data[i][j] == 1){
                    person.add(new Node(i,j));
                }
                else if(data[i][j] == 2){
                    chicken.add(new Node(i,j));
                }
            }
        }

        open = new boolean[chicken.size()];


        backTracking(0,0);

        System.out.println(result);
    }

    private static void backTracking(int depth, int at) {
        if(depth == M){
            check();
            return;
        }

        for(int i = at; i< chicken.size(); i++){
            open[i] = true;
            backTracking(depth+1,i+1);
            open[i] = false;
        }
    }

    private static int check() {
        int ans = 0;

        for(int i=0; i<person.size(); i++){
            int tmp = Integer.MAX_VALUE;
            for(int j = 0; j< chicken.size(); j++){
                if(open[j]){
                    int dis = Math.abs(person.get(i).x - chicken.get(j).x ) + Math.abs(person.get(i).y - chicken.get(j).y);
                    tmp = Math.min(tmp,dis);
                }
            }
            ans += tmp;
        }

        result = Math.min(ans,result);
        return result;
    }
}





















