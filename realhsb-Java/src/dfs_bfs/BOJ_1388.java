package dfs_bfs;

// BOJ 1388번 바닥 장식 

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_1388 {
   static int[] dx = {0, 1, 0, -1};
   static int[] dy = {1, 0, -1, 0};
   static char[][] field;
   static boolean[][] visited;
   static int N, M;
   static int answer;
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      M = sc.nextInt();
      int count = 0;
      sc.nextLine();   // 정수 입력 받고 난 후, 문자열 받을 때 공백 받아두기 
      field = new char[N][M];
      
      for(int i = 0; i < N; i++) {
         String s = sc.nextLine();
         field[i] = s.toCharArray();
      }
      
      // DFS
      visited = new boolean[N][M];
      answer = 0;
      DFS(0,0);
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < M; j++) {
            if(!visited[i][j]) {
               DFS(i,j);
               answer++;
            }
         }
      }
      System.out.println(answer);
      
      // BFS
      visited = new boolean[N][M];
      answer = 0;
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < M; j++) {
            if(!visited[i][j]) {
               answer++;
               BFS(i,j);
            }
         }
      }
      System.out.println(answer);

   }
   
   static void DFS(int i, int j) {   //깊이 
      visited[i][j] = true;
      if(field[i][j] == '-' && j+1 != M) {
         if(field[i][j+1] == '-' && !visited[i][j+1]) DFS(i, j+1);
      }else if (field[i][j] == '|' && i+1 != N) {
         if(field[i+1][j] == '|' && !visited[i+1][j]) DFS(i+1, j);
      }
      return;
   }
   
   
   static void BFS(int i, int j) { // 너비 
      Queue<int[]> queue = new LinkedList<>();
      queue.offer(new int[] {i, j});
      
      while(!queue.isEmpty()) {
         int now[] = queue.poll();
         visited[i][j] = true;
         for(int k = 0; k < 4; k++) {
            int x = now[0] + dx[k];
            int y = now[1] + dy[k];
            if(x >= 0 && y >= 0 && x < N && y < M) {
               if (field[i][j] == field[x][y] && field[i][j] == '-' && i == x && !visited[x][y]) {
                  visited[x][y] = true;
                  queue.add(new int[] {x,y});
               }else if(field[i][j] == field[x][y] && field[i][j] == '|' && j == y && !visited[x][y]){
                  visited[x][y] = true;
                  queue.add(new int[] {x,y});
               }
            }
         }
      }
   }
}