import java.io.*;
import java.util.*;

public class BOJ_1697 {
    static class Node {
        int x;

        Node(int x, int time) {
            this.x = x;
        }
    }
    static int sister;
    static int[] dx = {1,-1,2};
    static int[] visit = new int[100001];
    static List<Node> q = new ArrayList<Node>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        if(subin == sister) System.out.println(0);
        else{
            Node current = new Node(subin,0);
            q.add(current);
            visit[subin] = 1;
            bfs();
        }

    }

    private static void bfs() {
        while (!q.isEmpty()){
            Node current = q.remove(0);
            for(int i=0; i<3; i++){
                int move_x = 0;

                if(i==2) {
                    move_x = current.x * dx[i];
                }
                else {
                    move_x = current.x + dx[i];
                }

                if(move_x < 0 || move_x > 100000) continue;
                if(move_x == sister) {
                    visit[sister] = visit[current.x];
                    System.out.println(visit[sister]);
                    System.exit(0);
                }

                if(visit[move_x] == 0) {
                    Node move = new Node(move_x, visit[move_x] = visit[current.x] + 1);
                    q.add(move);
                }
            }
        }
    }
}
