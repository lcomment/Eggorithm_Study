package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// while문에서 
// 처음 돌 때는 전체, 두번째부터는 인구이동이 없었던 나라들만 돌고 싶은데 
// 속도차이가 그렇게 많이 날거 같지도 않고, 오히려 코드만 복잡해지고 메모리만 늘어날거 같아서 처리하지 않음
// 만약 인구이동이 한번 이상 일어난 국가와 관련해 체크해준 리뷰어는 comment에 메모리와 시간을 적어줬으면 좋겠슴당 
// -> 메모리: 299044KB, 시간: 616ms
public class BOJ_16234 {
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, L, R;
	static int[][] map;
	static int days = 0;
	static boolean[][] visited; 
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NLR = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NLR[0];
		L = NLR[1];
		R = NLR[2];
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++)
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		while(true) {
			boolean flag = false;	// 인구이동 체크를 위한 플래그 
			visited = new boolean[N][N];   // 방문체크는 매번 인구가 바뀌기 때문에 while-true문 안에서 생성 
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					if(!visited[r][c]) {
						boolean f = bfs(new Node(r, c));
						
						// flag의 값은 flag가 false일 때만 바꾼다 
						// (조건에 f도 넣을까 고민했지만 속도에 별 차이는 없을듯 싶다 -> 넣어보니 12ms 단축됨 ㅋㅋ)
						if(!flag)
							flag = f;
					}
				} // for_c
			} // for_r
			
			// 인구이동이 없었으면 그대로 break 
			if(!flag) break;
			// 있으면 days를 추가해준다 
			days++;
		} // while
		
		System.out.println(days);
	}
	
	static boolean bfs(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		visited[node.r][node.c] = true;
		
		// 연합들의 인구합과 구성 국가들을 각각 sum과 union에 저장 
		int sum = map[node.r][node.c];
		ArrayList<Node> union = new ArrayList<>();
		union.add(node);
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dir[i][0];
				int nc = n.c + dir[i][1];
				
				if(nr<0 || nc<0 || nr>N-1 ||nc>N-1 || visited[nr][nc]) continue;
				
				int condition = Math.abs(map[nr][nc] - map[n.r][n.c]);
				
				// 인구이동이 일어날 수 있으면 연합 맺기 
				if(L<= condition && condition <= R) {
					q.offer(new Node(nr, nc));
					visited[nr][nc] = true;
					union.add(new Node(nr, nc));
					sum += map[nr][nc];
				}
			}
		} // while
		
		return movePopulation(sum, union);
	}
	
	static boolean movePopulation(int sum, ArrayList<Node> union) {
		// 국가가 2개 이상이 아닐 때는 false return 
		if(union.size() == 1) return false;
		
		// 2개 이상일 땐 인구이동 후 true return
		int div = sum / union.size();
		
		for(Node n : union) {
			map[n.r][n.c] = div;
		}
		
		return true;
	}
}
