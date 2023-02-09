import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SW_2001 {
    static int[][] graph;
    static int N, M;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = 0;
            graph = new int[N][];

            for(int i = 0 ; i < N; i++){ // 그래프 초기화
                graph[i] = inputValues(br);
            }


            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(j + M <= N && i + M <= N) {
                        getSum(i, j, 0);
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    public static int[] inputValues(BufferedReader br) throws Exception{
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void getSum(int x, int y, int direct) {
        int total = 0;
        for(int i = x; i < x + M; i++) {
            for(int j = y; j < y + M; j++) {
                total += graph[i][j];
            }
        }
        answer = Math.max(answer, total);
    }
}