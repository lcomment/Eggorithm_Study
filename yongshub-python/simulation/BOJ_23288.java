import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// 0 : 동쪽, 1: 서쪽, 2: 남쪽, 3: 북쪽
public class BOJ_23288 {
    static int[][] graph;
    static Map<Integer, HashMap<String, Integer>> directions = new HashMap<>();
    static int N, M, K;
    static List<Integer> queue1 = new LinkedList<>();
    static List<Integer> queue2 = new LinkedList<>();
    static int currDirect = 0;
    static int curX = 0;
    static int curY = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        initializeMap(); // 방향 초기화
        initializeQueue(); // 주사위 초기화
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][];

        for(int i = 0; i < N; i++) {
            graph[i] = inputValues(br);
        }

        System.out.println(move(0, 0));
    }

    public static void initializeMap() { // 시계, 반시계, 반대 방향에 따른 방향 값 초기화
        //동쪽
        HashMap<String, Integer> direct = new HashMap<>();
        direct.put("시계", 2);
        direct.put("반시계", 3);
        direct.put("반대", 1);
        directions.put(0, direct);
        //서쪽
        direct = new HashMap<>();
        direct.put("시계", 3);
        direct.put("반시계", 2);
        direct.put("반대", 0);
        directions.put(1, direct);
        //남쪽
        direct = new HashMap<>();
        direct.put("시계", 1);
        direct.put("반시계", 0);
        direct.put("반대", 3);
        directions.put(2, direct);
        //북쪽
        direct = new HashMap<>();
        direct.put("시계", 0);
        direct.put("반시계", 1);
        direct.put("반대", 2);
        directions.put(3, direct);
    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void initializeQueue() { // 초기 큐 상태 초기화
        queue1.addAll(List.of(1, 5, 6, 2));
        queue2.addAll(List.of(1, 3, 6, 4));
    }
    public static int move(int x, int y) {
        int totalScore = 0;
        for(int i = 0; i < K; i++) {
            if(canNotMove(currDirect)) {
                currDirect = directions.get(currDirect).get("반대");
                canNotMove(currDirect);
            }
            if(currDirect == 0) {
                moveToEast();
                decisionDirect(0);
            }else if(currDirect == 1) {
                moveToWest();
                decisionDirect(1);
            } else if(currDirect == 2) {
                moveToSouth();
                decisionDirect(2);
            } else if(currDirect == 3) {
                moveToNorth();
                decisionDirect(3);
            }
            totalScore += bfs(graph[curX][curY]);
        }
        return totalScore;
    }

    public static int bfs(int number) { // 동서남북으로 움직일 수 있는 방향 체크
        boolean[][] visited = new boolean[N][M];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int nx, ny;
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>(List.of(curX, curY));
        visited[curX][curY] = true;

        while(queue.size() > 0) {
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || graph[nx][ny] != number) {
                    continue;
                }
                cnt++;
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }
        return cnt * graph[curX][curY];
    }

    public static void decisionDirect(int direct) { // 주사위의 값과 지도 의 값과의 비교
        if(queue1.get(2) > graph[curX][curY]) {
            currDirect = directions.get(direct).get("시계");
        }else if(queue1.get(2) < graph[curX][curY]) {
            currDirect = directions.get(direct).get("반시계");
        }
    }

    public static boolean canNotMove(int currDirect) { // 움직일 수 있는지 없는지 체크
        // 0 : 동쪽, 1: 서쪽, 2: 남쪽, 3: 북쪽
        int nx = curX;
        int ny = curY;
        if(currDirect == 0) {
            ny = curY + 1;
        }else if(currDirect == 1) {
            ny = curY - 1;
        }else if(currDirect == 2) {
            nx = curX + 1;
        }else if(currDirect == 3) {
            nx = curX - 1;
        }
        if(nx < 0 || nx >= N || ny < 0 || ny >= M){
            return true;
        }
        curX = nx;
        curY = ny;
        return false;
    }

    public static void moveToEast() {
        Collections.rotate(queue2,1); // queue2 오른쪽 회전
        queue1.set(0, queue2.get(0));
        queue1.set(2, queue2.get(2));
    }

    public static void moveToNorth() {
        Collections.rotate(queue1,-1); // queue1 왼쪽 회전
        queue2.set(0, queue1.get(0));
        queue2.set(2, queue1.get(2));
    }

    public static void moveToSouth() {
        Collections.rotate(queue1,1); // queue1 오른쪽 회전
        queue2.set(0, queue1.get(0));
        queue2.set(2, queue1.get(2));
    }

    public static void moveToWest() {
        Collections.rotate(queue2,-1); // queue1 왼쪽 회전
        queue1.set(0, queue2.get(0));
        queue1.set(2, queue2.get(2));
    }
}
