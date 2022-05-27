package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<N ; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(maxHeap.size() == minHeap.size())  maxHeap.offer(num);
			else  minHeap.offer(num);
			
			if( !maxHeap.isEmpty() && !minHeap.isEmpty() ) {
				// 두 힙의 최상위 노드를 비교하여 정렬 
				if(minHeap.peek() < maxHeap.peek()) {
					int sortedNum_min = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(sortedNum_min);
				}
			}
			sb.append(maxHeap.peek() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		// 실패한 로직 
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
//		
//		for(int i=0 ; i<N ; i++) {
//			int num = Integer.parseInt(br.readLine());
//			
//			queue.offer(num);
//			
//			if(queue.size() == 1 || queue.size() == 2)
//				System.out.println(queue.peek());
//			else {
//				queue.poll();
//				int center = queue.poll();
//				queue.poll();
//				System.out.println(center);
//				queue.offer(center);
//			}
//		} // for_i
	}
}