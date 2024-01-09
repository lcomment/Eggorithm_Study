import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9205{
    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static List<Node> gs;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int gsCount = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int goalX  = 0;
            int goalY = 0;

            list = new ArrayList[gsCount+2];
            visited = new boolean[gsCount+2];

            for(int j=0; j<gsCount + 2; j++){
                list[j] = new ArrayList<Integer>();
            }

            gs = new ArrayList<>();
            gs.add(new Node(startX, startY));

            for(int j=0; j<gsCount; j++){
                st= new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                gs.add(new Node(x,y));
            }

            st= new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            gs.add(new Node(goalX, goalY));

            for(int j=0; j<gsCount+2; j++){
                for(int k=j+1; k<gsCount+2; k++){
                    if(check(gs.get(j), gs.get(k))){
                        list[j].add(k);
                        list[k].add(j);
                    }
                }
            }
            bfs();
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);
        boolean flag = false;

        while(!q.isEmpty()){
            int tmp = q.poll();

            if(tmp == gs.size()-1){
                q.clear();
                flag = true;
                System.out.println("happy");
                break;
            }

            for(Integer next : list[tmp]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        if(!flag) System.out.println("sad");
    }

    private static boolean check(Node node, Node node1) {
        if(Math.abs(node.x - node1.x) + Math.abs(node.y - node1.y)  <= 1000){
            return true;
        }
        return false;
    }
}