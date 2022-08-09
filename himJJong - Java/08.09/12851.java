package chapter2;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class TypeInference {
	static int N, K, time, cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());	//시작위치 
		K = Integer.parseInt(st.nextToken());	//도착위치 
		bfs();
		System.out.println(time + "\n" +cnt);
	}
	private static void bfs() {
		int visit[] = new int[100001];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N,0));		//x축을 기준으로 처음 시작부분 
		visit[N] = 1;		
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();		//Point p인스턴스를 만든 후 하나씩 뽑아서
			if(p.x==K) {
				if(cnt == 0)
					time = p.y;			//가장빠른 시간
				if(time == p.y)
					cnt++;				  //빠른시간 개수 증가
				continue;
			}
			int arr[] = {p.x-1, p.x+1, p.x*2};            //질문 그러면 끝까지 다 돌아야 무조건 끝나는게 맞다?
			for(int i=0; i<3; i++) {
				int next = arr[i];
				if(next<0 || next>100000)	//범위를 넘으면 넘겨버리고 
					continue;
				if(visit[next]==0 || visit[next]==p.y+1) { //여기서 왼쪽은 방문하지 않은것이고, 
					visit[next] = p.y+1;				   //오른쪽은 BFS라 그 전에것의 값이 같다면 
					queue.add(new Point(next,p.y+1));
				}
			}
		}
	}
}
