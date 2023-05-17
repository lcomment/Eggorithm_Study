import java.util.PriorityQueue;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node implements Comparable<Node>{
    public int time;
    public int r;
    public int c;
    Node(int time, int r, int c){
        this.time = time;
        this.r = r;
        this.c = c;
    }
    @Override
    public int compareTo(Node node) {
        if(this.time < node.time) {
            return -1;
        }
        else if(this.time > node.time) {
            return 1;
        }
        return 0;
    }
}

//다익스트라
class ssafy_supply_dijkstra {

    static int n;
    static String[] graph = new String[100];
    static int[][] dp = new int[100][100];
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            //pq에 담겨있던 노드 탐색하려는데 이미 dp에 더 작은 값이 들어온 경우 스킵
            if(cur.time > dp[cur.r][cur.c]) continue;

            for(int i=0; i< 4; i++) {
                int nr = cur.r+dir[i][0];
                int nc = cur.c+dir[i][1];
                if(nr <0 || nr >=n || nc<0 || nc>=n) continue;
                //nr nc의 값이 현재 값보다 큰 경우만 탐색(갱신)
                int nextTime = cur.time + (graph[nr].charAt(nc)-'0');
                if(dp[nr][nc]>nextTime) {
                    dp[nr][nc] = nextTime;
                    pq.add(new Node(nextTime,nr,nc));
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // input
            n =Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++) {
                graph[i] = br.readLine();
            }
            //dp maxvalue로 초기화
            for(int i=0; i<n ;i++) {
                for(int j=0; j<n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;

            //solve
            dijkstra();
            //output
            System.out.println("#" + t+" " + dp[n-1][n-1]);

        }
    }
}