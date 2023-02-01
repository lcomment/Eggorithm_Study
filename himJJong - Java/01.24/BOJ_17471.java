import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {

    static int[] people;
    static int[][] graph;
    static int N;
    static List<Integer> A, B;
    static int pickCnt;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 두 선거구 A, B
        A = new ArrayList<>();
        B = new ArrayList<>();

        // 구역별 인구 수
        people = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            A.add(i);
        }

        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            // 간선 개수
            int cnt = Integer.parseInt(st.nextToken());
            for(int c=0; c<cnt; c++) {
                int vertex = Integer.parseInt(st.nextToken());
                graph[i][vertex] = 1;
                graph[vertex][i] = 1;
            }
        }

        // A 원소 중 개 뽑아 B에 넣으면
        // A 선거구에는 『(N-1)/2 ~ 1 』개가 남아 있으므로 두 선거구로 분리
        int end = (N%2) == 1 ? (N/2) + 1 : (N/2);
        for(pickCnt=1; pickCnt <= end; pickCnt++) {
            combination(0);
        }

        // 두 개의 선거구로 나누는 것이 불가능했는지 확인
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
        System.out.println(answer);
    }

    private static void combination(int idx) {
        if (B.size() == pickCnt) {
            // 각 선거구 연결성 확인
            if(BFS(A) && BFS(B)) {
                int people_of_A = 0;
                for(int i=0; i<A.size(); i++) {
                    people_of_A += people[A.get(i)];
                }
                int people_of_B = 0;
                for(int i=0; i<B.size(); i++) {
                    people_of_B += people[B.get(i)];
                }

                answer = Math.min(answer, Math.abs(people_of_A - people_of_B));
            }
            return;
        }

        if(idx >= A.size()) return;

        // A에서 현재 idx를 뽑은 경우
        B.add(A.remove(idx));
        combination(idx);

        A.add(idx, B.remove(B.size()-1));
        // A에서 뽑지 않고 다음 인덱스로 넘어간 경우
        combination(idx+1);
    }

    private static boolean BFS(List<Integer> list) {

        Queue<Integer> queue = new LinkedList<>();
        // 방문한 정점들을 저장할 배열
        boolean[] visited = new boolean[graph.length+1];

        // 리스트의 임의의 원소로 출발
        int v = list.get(0);
        queue.add(v);
        // 방문한 정점 표시
        visited[v] = true;

        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()) {
            int cur_v = queue.poll(); // 자료구조 큐에서 Dequeue과 같은 기능
            // 모두 연결되었는지 확인하기 위한 리스트
            temp.add(cur_v);
            // 해당 정점에서 방문할 수 있는 모든 정점 방문
            for(int i=1; i<graph.length; i++) {
                // 간선이 존재하고 지금까지 방문하지 않았던 정점을
                if(graph[cur_v][i] == 1 && !visited[i]) {
                    // 소속된 선거구를 떠나서 방문표시
                    visited[i] = true;
                    // 해당 선거구의 구역인지 확인
                    // 같은 선거구면 BFS 탐색 지속
                    if(list.contains(i)) {
                        queue.add(i);

                    }
                }
            }
        }
        // 나누어진 A, B 선거구에서 빠짐없이 있는지 확인  
        for(int i=0; i<list.size(); i++) {
            // 값을 들고 있지 않다면
            if(!temp.contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }
}