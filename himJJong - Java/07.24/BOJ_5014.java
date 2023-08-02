import java.io.*;
import java.util.*;

public class BOJ_5014 {
    static int f,s,g;
    static int[] move;
    static int[] dir = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        move = new int[f + 1];
        bfs(s);

    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[f+1];

        q.add(start);
        check[start] = true;
        move[start] = 0;

        while(!q.isEmpty()) {
            int pos = q.poll();
            if(pos == g) {
                System.out.println(move[pos]);
                return;
            }

            for(int i=0; i<2; i++) {
                int next = pos + dir[i];
                if(next > f || next <1 ) continue;

                if(!check[next]) {
                    check[next] = true;
                    q.add(next);
                    move[next]= move[pos]+1;
                }
            }
        }

        System.out.println("use the stairs");

    }
}