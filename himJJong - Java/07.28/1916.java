package algorithm;
import java.util.*;
import java.io.*;


import java.io.*;

public class plus{
	static int N,M;
	static ArrayList<Node>[] list; //인접리스트로 그래프 표현하기 
	static boolean[] visit;	   //사용 노드인지 확인 
	static int[] dist;           //최단 거리 배열 
    public static void main(String[] args) throws IOException{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1]; 			  // 장소 1번 부터 시작이기때문
        dist = new int[N+1];	  			  // 거리 값을 가진 배열 
        visit = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 거리 배열을 큰 수로 초기화
        for(int i=0; i<=N ;i++) {
        	list[i] = new ArrayList<Node>();
        }
        
        for(int i=0; i<M ; i++) {			  //그래프 거리(엣지) 표현 
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	list[start].add(new Node(end,weight));
        }
        
        st = new StringTokenizer(br.readLine());
        
        int startIndex = Integer.parseInt(st.nextToken());	//목표 출발 지점 
        int endIndex = Integer.parseInt(st.nextToken()); 	//목표 도착 지점 
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dijkstra(int start, int end) {   // (startIndex, endIndex) 
    	PriorityQueue<Node> pq = new PriorityQueue<>(); //우선 순위큐 
    	pq.offer(new Node(start, 0));
    	dist[start] = 0;					//자기 자신 0 
    	while(!pq.isEmpty()) {				//넣은 pq가 없을때까지 while문 돌고 
    		Node nowNode = pq.poll();		//nownode 객체 =  pq로 빼내는 값을 저장 (targetNode, value)  
    		int now = nowNode.targetNode;	//now = 현재 값이 nownode객체의 목표 지점 
    		if(!visit[now]) {				//목표한 곳이 방문하지 않았다면  
    			visit[now] = true;			//방문했다고 true 로 바꾼 후  
    			for(Node n :list[now]) {	// 현재 엣지 개수만큼 작은값일때 업데이트 , List는 동시에 입력되는 ArrayList개수 만큼 도는
    				if(!visit[n.targetNode]&&dist[n.targetNode]>dist[now]+n.value) {  
    					dist[n.targetNode] = dist[now] + n.value;			// 값이 적다면 업데이트 now(출발지점)의 거리(목표직전까지) + 목표 n(거리값) 
    					pq.add(new Node(n.targetNode, dist[n.targetNode])); // pq에 추가해준다. 
    				}
    			}
    		}
    	}
    return dist[end];
    }
   }
class Node implements Comparable<Node>{		//거리 값이 작은거부터 시작 
	int targetNode;							//목표 지점 
	int value;								//목표쪽 거리 
	Node(int targetNode, int value){		//객체 사용하기 위한 생성자 
		this.targetNode = targetNode;
		this.value = value;
	}
	@Override
	public int compareTo(Node o) {			//value값이 적은거로 오름차순 
		return value - o.value;
	}
}
