package greedy;

// BOJ 1826 연료채우기

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1826_연료채우기 {
	static int N, L, P;
	//  주유소의 개수 N(1 ≤ N ≤ 10,000)
	//  성경이의 시작 위치에서 주유소 까지의 거리 a(1 ≤ a ≤ 1,000,000) 
	//  주유소에서 채울 수 있는 연료의 양 b(1 ≤ b ≤ 100) 
	//  성경이의 위치에서 마을까지의 거리 L(1 ≤ L ≤ 1,000,000) 
	// 	트럭에 원래 있던 연료의 양 P(1 ≤ P ≤ 1,000,000) 
	public static void main(String[] args) throws IOException {
		List<GasStation> gs = new ArrayList<>();
		PriorityQueue<Integer> gsPQ = new PriorityQueue<>(Collections.reverseOrder());	// 내림차순 정렬...!
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gs.add(new GasStation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(gs);	// 보석도둑에서도 List에 담고 정렬했는데 굳이 이렇게 안 하고 우선순위큐에 담아도 될 듯 
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());	// 마을과의 거리 
		P = Integer.parseInt(st.nextToken());	// 현재 연료량 
		
		int now = P;	// 현재 갈 수 있는 거리 == 연료량 
		int count = 0;	// 주유소 들린 횟수 
		
		int index = 0;
		while(now < L) {
			for(int i = index; i < N && gs.get(i).a <= now; i++) {	
				//  갈 수 있는 주유소 개수 < N(총 주유소 개수)   &&    주유소 거리 <= 트럭이 갈 수 있는 거리 
				gsPQ.add(gs.get(i).b);		// 우선순위 큐(gsPQ)에 연료를 내림차순으로 담기 
				index++;
			}
			
			if(gsPQ.isEmpty()) {	// 마을에 도달하지 못하고, 주유소도 없을 때 
				count = -1;
				break;
			}
			now += gsPQ.poll();				// 마을에 도달할 때까지 연료 넣기 
			count++;						// 주유소에 들린 횟수 
		}
		
		System.out.println(count);
	}
}

class GasStation implements Comparable<GasStation> {
	int a;	// 주유소 거리 
	int b;	// 주유소 연료 
	GasStation(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(GasStation s) {	// 거리 기준으로 정렬   
		return this.a - s.a;				// a를 b로 써서 계속 틀렸네 ,..
	}
}