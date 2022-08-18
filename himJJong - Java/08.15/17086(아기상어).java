package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference{
	static int N,M;												//공간크기 
	static int[][] arr, dis;									//배열, 거리 
	static int[] dx = {-1,1,0,0,1,1,-1,-1};						//8방향 
	static int[] dy = {0,0,1,-1,1,-1,1,-1};
	
	static class Node{
		int x,y;
		
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
    public static void main(String[] args)throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	Queue<Node> queue = new LinkedList<>();
    	int answer =0;

    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[N][M];
    	dis = new int[N][M];
    	
    	for(int i=0; i<N ;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M ;j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
    			dis[i][j] = Integer.MAX_VALUE;			 //Max_value로 dis 초기화 
    			if(arr[i][j]==1) {					     //상어가 존재한다면 queue에 넣고 그 자리의 Node생성, 그자리 거리는 0 
    				queue.add(new Node(i,j));			 // 끝나면 상어가 있는 좌표 Node가 queue에 존재, dis[i][j]=0
    				dis[i][j]=0;
    			}
    		}
    	}
    	while(!queue.isEmpty()) {
    		Node now = queue.poll();
    		
    		for(int i=0; i<8;i++) {					 	//탐색 시작 
    			int next_x = now.x + dx[i];
    			int next_y = now.y + dy[i];
    			
    			if(next_x >=0 && next_y >=0 && next_x<N &&next_y<M) {		
    				if(dis[next_x][next_y]>dis[now.x][now.y]+1) {
    					dis[next_x][next_y]=dis[now.x][now.y]+1;
    					queue.add(new Node(next_x, next_y));
    					answer = Math.max(answer, dis[next_x][next_y]);
    				}
    			}
    		}
    		
    	}
    	System.out.println(answer);
    }
}
