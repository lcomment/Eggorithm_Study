import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_6593 {
    static class Node{
        int x;
        int y;
        int z;
        int time;
        Node(int x, int y, int z, int time){
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }

    }
    static int layer;
    static int row;
    static int col;
    static int flag = 0;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static String[][][] data;
    static List<Integer> start = new ArrayList<>();
    static List<Integer> end = new ArrayList<>();
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static boolean[][][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while (true){
            st = new StringTokenizer(br.readLine());
            layer = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            start.clear();
            end.clear();
            min = Integer.MAX_VALUE;

            if(layer == 0 && row == 0 && col ==0) {
                break;
            }
            data = new String[layer][row][col];
            visited = new boolean[layer][row][col];

            for(int i=0; i < layer; i++){
                for(int j=0; j< row; j++){
                    String[] tmp = br.readLine().split("");
                    for(int k=0; k<col; k++){
                        data[i][j][k] = tmp[k];
                        if(tmp[k].equals("S")){
                            start.add(i);
                            start.add(j);
                            start.add(k);
                        }
                        else if(tmp[k].equals("E")){
                            end.add(i);
                            end.add(j);
                            end.add(k);
                        }
                    }
                }
                br.readLine();
            }


            bfs(start.get(0),start.get(1),start.get(2));
            if(min == Integer.MAX_VALUE) System.out.println("Trapped!");
            else{
                System.out.println("Escaped in "+min+" minute(s).");
            }
            min = 0;
        }
    }

    private static void bfs(Integer x, Integer y, Integer z) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,z,0));

        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<6; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;
                int moveZ = dz[i] + tmp.z;

                if(moveX == end.get(0) && moveY == end.get(1) && moveZ == end.get(2)){
                    q.clear();
                    min = tmp.time + 1;
                    break;
                }
                if(moveX >= 0 && moveY >= 0 && moveZ >= 0 && moveX < layer && moveY < row && moveZ < col && !visited[moveX][moveY][moveZ] && (data[moveX][moveY][moveZ].equals(".") || data[moveX][moveY][moveZ].equals("E"))){
                    visited[moveX][moveY][moveZ] = true;
                    q.add(new Node(moveX,moveY,moveZ, tmp.time+1));
                }
            }
        }

    }
}
