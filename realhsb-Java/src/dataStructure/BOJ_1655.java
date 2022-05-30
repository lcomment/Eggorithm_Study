package dataStructure;

// BOJ - 1655번 가운데를 말해요 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class BOJ_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		int mid = Integer.parseInt(br.readLine());
		
		// 버퍼에 int만 넣으면 입력되지 않음 
		bw.write(mid+"\n");
//		System.out.print(minPQ);
//		System.out.print(mid);
//		System.out.println(maxPQ);
		int num;
		for(int i = 1; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if(i%2==1) {	// 홀  
				if(mid < num) {
					maxPQ.add(num);
				}else {
					minPQ.add(num);
					maxPQ.add(mid);
					mid = minPQ.poll();
					
				}	
			}else {			// 짝 
				if(mid < num) {
					maxPQ.add(num);
					minPQ.add(mid);
					mid = maxPQ.poll();
				}else {
					minPQ.add(num);
				}
			}
			bw.write(Integer.toString(mid));
			if(i!=N-1) {
				bw.write("\n");
			}
//			System.out.print(minPQ);
//			System.out.print(mid);
//			System.out.println(maxPQ);
		}
		bw.flush();
		br.close();
	}
}



