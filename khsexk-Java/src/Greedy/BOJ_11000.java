package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11000 {
	static class Task {
		int start, end;
		Task(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	static int N;
	static ArrayList<Task> taskList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			taskList.add(new Task(input[0], input[1]));
		}
		Collections.sort(taskList, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				int result = o1.start - o2.start;
				
				if(result == 0)
					return o1.end - o2.end;
				
				return result;
			}
		});
		
		int cnt = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(taskList.get(0).end);
		
		for(int i=1 ; i<N ; i++) {
			if(pq.peek() <= taskList.get(i).start)
				pq.poll();
			pq.offer(taskList.get(i).end);
		}
		
		System.out.println(pq.size());
	}

}

//public class BOJ_11000 {
//	static class Task {
//		int start, end;
//		Task(int start, int end){
//			this.start = start;
//			this.end = end;
//		}
//	}
//	
//	static int N;
//	static ArrayList<Task> taskList = new ArrayList<>();
//	
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		
//		for(int i=0 ; i<N ; i++) {
//			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//			taskList.add(new Task(input[0], input[1]));
//		}
//		Collections.sort(taskList, new Comparator<Task>() {
//			@Override
//			public int compare(Task o1, Task o2) {
//				int result = o1.end - o2.end;
//				
//				if(result == 0)
//					return o1.start - o2.start;
//				
//				return result;
//			}
//		});
//		
//		int cnt = 0;
//		
//		while(true) {
//			int start = taskList.get(0).end;
//			ArrayList<Task> remainTask = new ArrayList<>();
//			
//			for(int i=1 ; i<taskList.size() ; i++) {
//				if(start <= taskList.get(i).start) {
//					start = taskList.get(i).end;
//				} else {
//					remainTask.add(taskList.get(i));
//				}
//			}
//			cnt++;
//			taskList = new ArrayList<>(remainTask);
//			
//			if(taskList.size() == 1) {
//				cnt++;
//				break;
//			}
//		}
//		
//		System.out.println(cnt);
//	}
//
//}
