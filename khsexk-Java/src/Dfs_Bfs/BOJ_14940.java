package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static class Node{
        int r, c, cnt;
        Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
    	int map[][] = new int[R][C];
    	int route[][] = new int[R][C];
    	for(int i=0; i<R; i++){
    	    for(int j=0; j<C; j++){
    	        route[i][j] = -1;
    	    }   
    	}
    	boolean visited[][] = new boolean[R][C];
    	
    	Queue<Node> q = new LinkedList<>();
    	
		boolean flag = false;
		for(int i=0 ; i<R ; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(!flag) {
				for(int j=0 ; j<C ; j++) {
					if(map[i][j] == 2) {
						q.add(new Node(i, j, 0));
						visited[i][j] = true;
	    	            route[i][j] = 0;
						flag = true;
						break;
					}
				}
			}
		} // for_i
    	
    	while(!q.isEmpty()){
    	    Node n = q.remove();
    	    int r = n.r;
    	    int c = n.c;
    	    int cnt = n.cnt;
    	    route[r][c] = cnt;
    	    
    	    for(int i=0; i<4; i++){
    	        int nr = r + dr[i];
    	        int nc = c + dc[i];
    	        
    	        if(nr<0 || nc<0 || nr>R-1 || nc>C-1) continue;
    	        if(visited[nr][nc] || map[nr][nc]==0) continue;
                
    	        visited[nr][nc] = true;
    	        q.add(new Node(nr, nc, (cnt+1)));
    	    }
    	}
    	
    	for(int i=0; i<R; i++){
    	    for(int j=0; j<C; j++){
    	        if(map[i][j] == 0) route[i][j] = 0;
    	    }   
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<R; i++){
    	    for(int j=0; j<C; j++){
    	        sb.append(route[i][j] + " ");
    	    }sb.append("\n");
    	}
    	System.out.println(sb);
    }
}