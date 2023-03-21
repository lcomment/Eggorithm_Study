import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236 {
    public static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int n;
    static int[][] data;
    static int dx[] = {-1, 0, 1, 0}; //위 왼 아래 오
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        data = new int[n][n];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
                if(data[i][j] == 9){
                    q.add(new Node(i, j, 0));
                    data[i][j] = 0;
                }
            }
        }

        int eat = 0;
        int time = 0;
        int age = 2;

        while(true){
            LinkedList<Node> fish = new LinkedList<>();
            int[][] dist = new int[n][n];                   // data -> 입력 데이터의 테이블     dist -> 물고기의 위치에서 거리를 나타낸 테이블

            // BFS
            while (!q.isEmpty()) {
                Node current = q.poll();
                for(int i=0; i<4; i++){
                    int moveX = current.x + dx[i];
                    int moveY = current.y + dy[i];

                    if(moveX >= 0 && moveY >= 0 && moveX < n && moveY < n && dist[moveX][moveY]==0 && data[moveX][moveY] <= age){
                        dist[moveX][moveY] = dist[current.x][current.y] + 1;
                        q.add(new Node(moveX, moveY, dist[moveX][moveY]));
                        if(1 <= data[moveX][moveY] && data[moveX][moveY] <= 6 && data[moveX][moveY] < age) {
                            fish.add(new Node(moveX, moveY, dist[moveX][moveY]));
                        }
                    }

                }
            }// BFS 끝

            if(fish.size() == 0){   // 먹을게 없다면 엄마 상어 호출
                System.out.println(time);
                return;
            }

            Node currentFish = fish.get(0);
            for(int i = 1; i < fish.size(); i++){       //i를 1로 한 이유는 물고기가 1개라면 바로 접근해야하기 때문
                if(currentFish.dist > fish.get(i).dist) {                           //거리는 가까운거부터
                    currentFish = fish.get(i);
                }
                else if(currentFish.dist == fish.get(i).dist) {
                    if(currentFish.x > fish.get(i).x) currentFish = fish.get(i);    //차이가 있다면 위쪽부터
                    else if(currentFish.x == fish.get(i).x){                        //x가 같다면
                        if(currentFish.y > fish.get(i).y) currentFish = fish.get(i);//왼쪽부터
                    }
                }
            }

            time += currentFish.dist;
            eat++;
            data[currentFish.x][currentFish.y] = 0;             //먹은 물고기 없애기

            if(eat == age) {    //먹은 수와 나이의 수가 같다면 level up~
                age++;
                eat = 0;
            }

            q.add(new Node(currentFish.x, currentFish.y, 0));
        }
    }
}    