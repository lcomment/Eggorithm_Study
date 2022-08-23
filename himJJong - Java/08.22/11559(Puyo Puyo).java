import java.util.*;
import java.io.*;

public class Main{
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static char[][] map = new char[12][];
	static int[][] dis = { {1,0}, {-1,0}, {0,1}, {0,-1}};
	static boolean[][] resetMap = new boolean[12][6];
	
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 0;
        for(int i=0; i<12; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        while(canBreak()) {					//4개 이상인지 BFS탐색 
        	breakMap();						//4개 찾은거 터트리기 
        	moveMap();						//터진거 내리기 -> 여기서 고민이 많았음.
        	resetMap = new boolean[12][6];	//삭제했으면 map초기화 
        	count++;
        }
        System.out.println(count);
	}
  
  
	
  //메서드 차례로 
	static boolean canBreak() {			// <1> -> 깰 수 있나요? 확인 
		boolean canbreak = false;
		boolean[][] visited = new boolean[12][6];
		
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(map[i][j]=='.' || visited[i][j]) continue;
				
				// 색이 있다면 
				if(group(i, j, visited)) {    // 그룹 찾기 BFS 확인 
					canbreak = true;
				}
			}
		}
		return canbreak;
	}
  
  
	static boolean group(int x, int y, boolean[][] visited) { // <2> -> 그룹 찾기 BFS
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> list = new ArrayList<>();
		char color = map[x][y];			// color에 색 담고 
		
		q.add(new Point(x,y));
		list.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nowx = now.x + dis[i][0];
				int nowy = now.y + dis[i][1];
			
				if(!isInner(nowx, nowy) || visited[nowx][nowy] || map[nowx][nowy] != color) 
					continue;
			
				visited[nowx][nowy] = true;
				q.add(new Point(nowx,nowy));
				list.add(new Point(nowx,nowy));
			}
		}
		if(list.size()>=4) {
			for(Point now: list) {
				resetMap[now.x][now.y] = true;              // 그룹 찾았다면 true로 변경 
			}
			return true;
		}
		return false;
	}
	
	static void breakMap() {                          // 그룹이 4개라면 해당 색 좌표 '.'로 변경 
		for(int i=0; i<12 ; i++) {
			for(int j=0; j<6; j++) {
				if(!resetMap[i][j]) continue;
				map[i][j] = '.';
			}
		}
		
	}
	static void moveMap() {                           // 여기서 생각을 많이 했던거는 색깔 사이나 색 밑에 '.'를 고민했는데 문제를 잘 읽어보면 그럴 수 없다는 조건이 있음. 
	  for(int i=0; i<6; i++) {
		  ArrayList<Character> check = new ArrayList();
			for(int j=11 ; j>=0; j--) {
				if(map[j][i]=='.') continue;
				check.add(map[j][i]);
			}
			if(check.size()==0) continue;
			
			for(int j=0; j<12; j++) {
				if( j < check.size()) {
					map[11-j][i] = check.get(j);	//색깔 내리기 
				}
				else {
					map[11-j][i] = '.';
				}
		}
	 }
	}
  
	static boolean isInner(int x, int y) {		        //범위 내에 있는지 
		if((0<=x && x<12) && (0<=y && y<6)) {
			return true;
		}
		else
			return false;
	}
}
