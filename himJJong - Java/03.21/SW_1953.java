import java.io.*;
import java.util.*;

public class SW_1953 {
    static class Node{
        int x;
        int y;
        int time;
        Node(int x,int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int[][] data;
    static int[] NM;
    static boolean[][] visited;
    static List<Node> q = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        data = new int[NM[0]][NM[1]];
        for(int i=0; i<NM[0]; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        visited = new boolean[NM[0]][NM[1]];
        Node data = new Node(NM[2],NM[3],1);
        bfs(data);
        for(int i=0; i<NM[0]; i++){
            for (int j=0; j<NM[1]; j++){
                if(visited[i][j]) answer++;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(Node data) {
        q.add(data);
        visited[data.x][data.y] = true;
        while(!q.isEmpty()){
            Node tmp = q.remove(0);
            moveWhere(tmp.x,tmp.y, tmp.time);
        }
    }

    private static void moveWhere(int x, int y,int count) {
        if(data[x][y]==1){  //아래 오른쪽 위 왼
            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];

                if(i==0 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 ||data[moveX][moveY] == 2 || data[moveX][moveY] == 4 ||  data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==1 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 ||data[moveX][moveY] == 3 || data[moveX][moveY] == 6 ||  data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==2 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 ||data[moveX][moveY] == 2 || data[moveX][moveY] == 5 ||  data[moveX][moveY] == 6) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==3 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 ||data[moveX][moveY] == 3 || data[moveX][moveY] == 4 ||  data[moveX][moveY] == 5) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
            }
        }
        else if(data[x][y]==2){ // 아래 위
            int[] dx = {1,-1};
            int[] dy = {0,0};
            for(int i=0;i<2;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];

                if(i==0 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 2 ||data[moveX][moveY] == 1 || data[moveX][moveY] == 4 ||  data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==1 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 2 ||data[moveX][moveY] == 1 || data[moveX][moveY] == 5 ||  data[moveX][moveY] == 6) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
            }
        }
        else if(data[x][y]==3){ // 오른쪽 왼쪽
            int[] dy = {1,-1};
            int[] dx = {0,0};
            for(int i=0;i<2;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];

                if(i==0 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 3 ||data[moveX][moveY] == 1 || data[moveX][moveY] == 6 ||  data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==1 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 3 || data[moveX][moveY] == 4 ||  data[moveX][moveY] == 5) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
            }

        }
        else if(data[x][y]==4){ // 위 오른쪽
            int[] dx = {-1,0};
            int[] dy = {0,1};
            for(int i=0;i<2;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];

                if(i==0 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 2 ||  data[moveX][moveY] == 5 || data[moveX][moveY] == 6) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==1 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 3 || data[moveX][moveY] == 6 || data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
            }
        }
        else if(data[x][y]==5){ // 아래 오른쪽
            int[] dx = {1,0};
            int[] dy = {0,1};
            for(int i=0;i<2;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];

                if(i==0 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 2 ||  data[moveX][moveY] == 4 || data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==1 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 3 || data[moveX][moveY] == 6 || data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
            }
        }
        else if(data[x][y]==6){ // 아래 왼쪽
            int[] dx = {1,0};
            int[] dy = {0,-1};
            for(int i=0;i<2;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];

                if(i==0 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 2 ||  data[moveX][moveY] == 4 || data[moveX][moveY] == 7) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==1 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 3 || data[moveX][moveY] == 4 || data[moveX][moveY] == 5) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
            }

        }
        else if(data[x][y]==7){ // 위 왼쪽
            int[] dx = {-1,0};
            int[] dy = {0,-1};
            for(int i=0;i<2;i++){
                int moveX = x+dx[i];
                int moveY = y+dy[i];

                if(i==0 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 2 ||  data[moveX][moveY] == 5 || data[moveX][moveY] == 6) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
                else if(i==1 && moveX>=0 && moveX < NM[0] && moveY >=0 && moveY <NM[1] &&data[moveX][moveY] !=0){
                    if((data[moveX][moveY] == 1 || data[moveX][moveY] == 3 || data[moveX][moveY] == 4 || data[moveX][moveY] == 5) && !visited[moveX][moveY] && count < NM[4]){
                        visited[moveX][moveY] = true;
                        Node tmp = new Node(moveX,moveY,count+1);
                        q.add(tmp);
                    }
                }
            }
        }
    }
}
