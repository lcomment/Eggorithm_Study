/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class ssafy_supply_bfs
{
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y ;
        }
    }
    static int[][] data;
    static int[][] ans;
    static boolean[][] visited;
    static int N;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Node> q = new LinkedList<>();
    static int answer;
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)	{
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;

            data = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                data[i] = Arrays.stream(br.readLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            ans = new int[N][N];

            for(int i=0; i<N; i++){
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            ans[0][0] = 0;

            q.add(new Node(0,0));
            visited[0][0] = true;

            bfs();
            System.out.println("#"+test_case+" "+answer);
        }
    }
    public static void bfs(){
        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp.x == N-1 && tmp.y == N-1){
                answer = Math.min(answer, ans[N - 1][N - 1]);
            }
            if(answer <= ans[tmp.x][tmp.y])    continue;
            for(int i=0; i<4; i++){
                int moveX = tmp.x + dx[i];
                int moveY = tmp.y + dy[i];

                if(moveX >=0 && moveY >=0 && moveX<N && moveY <N ){
                    if(!visited[moveX][moveY] || (ans[moveX][moveY] > ans[tmp.x][tmp.y] + data[moveX][moveY])){
                        visited[moveX][moveY] = true;
                        ans[moveX][moveY] = ans[tmp.x][tmp.y] + data[moveX][moveY];
                        q.add(new Node(moveX, moveY));
                    }
                }
            }
        }
    }
}