import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MonthName {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		String first = "";
		String second = "";
		long[] data = new long[3];
		
		for(int i=0; i<3; i++) {
			data[i] = Long.parseLong(st.nextToken());
		}
		
		long[] score = new long[(int) data[0]];
		
		if(data[0]==0) {
			System.out.println(1);
		}
		else if(data[0]==1) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<data[0] ; i++) {
				score[i] = Long.parseLong(st.nextToken());
			}
			if(data[1]>score[0])	System.out.println(1);
			else if(data[1]==score[0]) System.out.println(1);
			else if(data[1]<score[0]) System.out.println(2);
		}
		else {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<data[0]; i++) {
				score[i] = Long.parseLong(st.nextToken());
				first+=score[i];
			}
			
			pq.add((long) data[1]);
			for(int i=0; i<data[0]; i++) {
				pq.add(score[i]);
				if(score[i]==0) break;
			}
			
			long[] score2 = new long[(int) (data[0]+1)];
			
			int k =0;
			if(data[2]==data[0]) {
				while(data[0]-- >0) {
					score2[k]=pq.remove();
					second+=score2[k];
					k++;
				}
			}
			
			else {
				while(pq.size()>0) {
					score2[k]=pq.remove();
					second+=score2[k];
					k++;
				}
			}
			
			if(first.equals(second)) System.out.println(-1);
			else {
				for(int i=0; i<score2.length;i++) {
					if(i==score2.length-1) {
						System.out.println(issame(score2,i)+1);
						break;
					}
					if(score[i]==score2[i]) {
						continue;
					}
					else {
						System.out.println(issame(score2,i)+1);
						break;
					}
				}
			}
		}
	}
	static int issame(long[] arr, int num) {
		int rank = 0;
		int answer = 0;
		for(int i=num; i>1 ; i--) {
			if(arr[i]==arr[i-1]) {
				rank = i-1;
				answer = rank;
			}
			else {
				rank = i;
				answer = rank;
				break;
			}
		}
		if(rank==1 && arr[1]==arr[0]) {
			rank=0;
			answer = rank;
		}
		
		return answer;
	}
}
