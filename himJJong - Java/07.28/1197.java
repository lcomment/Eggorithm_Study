package algorithm;
import java.io.*;
import java.util.*;;
 
public class plus {
	static int parent[];
	static int result;
	static PriorityQueue<edge> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());		//정점 개수 
		int e = Integer.parseInt(st.nextToken());		//간선 개수 
		parent = new int[v+1];							        //정점 번호에 맞게 값을 넣어주려고 +1크기 배열  
		
		for(int i=0; i<v+1; i++) {
			parent[i] = i;								            //정점 과 배열의 값은 자기 자신으로 초기화 왜? 아직 루트노드는 자기 자신이기 
		}
		
		for(int i=0; i<e ; i++) {						        //weight크기 대로 오름차순 왜? -> Comparable<edge>
			st = new StringTokenizer(br.readLine());	
			pq.add(new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())));
		
		}
		
		Kruskal();										             //입력 받은 후 시작 
		System.out.println(result);
	}
	
	static class edge implements Comparable<edge>{
		int start;
		int end;
		int weight;
		
		edge(int start, int end, int weigth){		  //사용하기 위해 초기화  
			this.start=start;
			this.end = end;
			this.weight = weigth;
		}
		
		//weigth로 오름차순 정렬
		@Override
		public int compareTo(edge o) {
			return weight - o.weight;
		}
	}
	
	static void Kruskal() {
		while(!pq.isEmpty()) {					//pq안 edge의 정보들이 비어있지 않을때까지 
			edge cur = pq.poll();					//들어간 순서대로 poll(); 
			
			int a = find(cur.start);			//정점.start
			int b = find(cur.end);				//정점.end 
		
			if(a==b) {
				continue;							      //정점끼리의 값을 확인 후 자신의 루트노드와 값 확인 후 같다면 continue  
			}
			union(a,b);								    //다르다면 union(a,b) 시작 
			result += cur.weight;					//union을 실행했다는 것은 서로 합쳐졌다는 의미이고, 새로운 정점이 추가되었기에 weight를 추가해준
		}											          //이때 weight가 최소인 이유는 edge클래스에서 weight를 오버라이드하여 오름차순으로 정려했기 때문 
	}
	
	
	static int find(int x) {
		if(x == parent[x]) {                      // 자기 자신이 루트노드라면 그대로 반환 
			return x;
		}
		else {
			return parent[x] = find(parent[x]);     // 해당 정점의 루트노드를 알아가는 과정 
		}
	}
	
	
	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		                                          //값에 따라 부모와 자식노드를 정해줌  
		if(xRoot != yRoot) {
			if(x<y) parent[yRoot] = x;
			else parent[xRoot] = y;
		}
	}
	
	
}
