import java.io.*;
import java.util.*;

public class BOJ_4485 {
    static class Node{
        int x;
        int y;
        int cost;
        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int count;
    static int data[][];
    static int dist[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;

        while(true){
            count = Integer.parseInt(br.readLine());
            if(count==0)    System.exit(0);

            data = new int[count][count];

            for(int i=0; i<count; i++){
                data[i] = Arrays.stream(br.readLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                Arrays.fill(dist[i],12700);
            }

            dist[0][0] = data[0][0];
            pq.offer(new Node(0,0, data[0][0]));

            dijkstra();
            System.out.println("Problem "+index+": "+dist[count-1][count-1]);
            index++;
        }
    }

    private static void dijkstra() {
        while(!pq.isEmpty()){
               Node tmp = pq.poll();
               for(int i=0; i<4; i++){
                   int moveX = tmp.x + dx[i];
                   int moveY = tmp.y + dy[i];

                   if(inArea(moveX,moveY)){
                       dist[moveX][moveY] = Math.min(dist[moveX][moveY], tmp.cost + data[moveX][moveY]);
                       pq.add(new Node(moveX,moveY, dist[moveX][moveY]));
                   }
               }
        }
    }

    private static boolean inArea(int moveX, int moveY) {
        return moveX >= 0 && moveX < count && moveY >= 0 && moveY < count;
    }
}
