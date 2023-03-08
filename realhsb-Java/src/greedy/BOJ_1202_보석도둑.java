package greedy;

// BOJ 1202 보석도둑 

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑 {
	static int N, K, M, V, C;	
	// 1 <= N(보석 개수), K(가방 개수) <= 300,000
	// 0 <= M(보석 무게), V(보석 가격) <= 1,000,000
	// 1 <= C(가방 용량) <= 100,000,000
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Jewel> jewelList = new ArrayList<>();
		List<Integer> bagList = new ArrayList<>();
		
		// 값 내림차순 정렬 (top 값이 가장 큼)
		PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewelList.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int i = 0; i < K; i++) {
			bagList.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(jewelList);	// 보석 무게 오름차순 
		Collections.sort(bagList);		// 가방 용량 오름차순 

		int index = 0;
		long sum = 0;	// 수 범위 확인하고, 타입 조심하기. 
		
		// 가방 개수만큼 반복문 실행 
		for(int i = 0; i < K; i++) {
			int bag = bagList.get(i);
			
			// 보석은 1번 씩만 검토
			// 가방에 담을 수 있는 보석을 우선순위큐(temp)에 담는다. (보석의 무게가 가방 용량보다 작거나 같은 것들만 우선순위큐(temp)에 담김.)
			// 가방을 오름차순으로 정렬했기 때문에, 우선순위큐(temp)에 있는 보석의 무게의 가방의 용량을 넘지 않음.
			while((index < jewelList.size()) && (bag >= jewelList.get(index).m)) { // 조건문 순서도 중요하네... 
				temp.add(jewelList.get(index).v);
				index++;
			}
			
			if(!temp.isEmpty()) sum += temp.poll();	// 우선순위큐(temp)의 top에 있는 보석이 ( 가방에 담을 수 있고 / 가장 비쌈)
		}
		
		System.out.println(sum);
	}

}

class Jewel implements Comparable<Jewel> {
	int m;	// 보석 무게 
	int v;	// 보석 가격 
	
	Jewel(int m, int v) {
		this.m = m;
		this.v = v;
	}

	@Override
	public int compareTo(Jewel j) {	// 보석 무게 오름차순 정렬 
		return this.m - j.m;
	}
}