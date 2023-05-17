import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class softeer_obstacleRecognize {
    static class Node{
        int x;
        int y;
        int val;
        Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    static int N;
    static int[][] data;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int count = 1;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        data = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            data[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && data[i][j] == 1){
                    int answer = bfs(i,j);
                    list.add(answer);
                    data[i][j] = count;
                    count++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }

    private static int bfs(int i, int j) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        Node tmp = new Node(i,j,data[i][j]);
        visited[i][j] = true;
        q.add(tmp);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int k=0; k<4; k++){
                int moveX = cur.x + dx[k];
                int moveY = cur.y + dy[k];

                if(moveX>=0 && moveX < N && moveY>=0 && moveY < N && !visited[moveX][moveY] && data[moveX][moveY] == 1){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY,count));
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
