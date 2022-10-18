// 여러 반례를 찾아가며 오류 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MonthName {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());	//우선순위 큐 
		
		String first = "";
		String second = "";
		long[] data = new long[3];
		
		for(int i=0; i<3; i++) {
			data[i] = Long.parseLong(st.nextToken());
		}
		
		long[] score = new long[(int) data[0]];
		
		if(data[0]==0) {								//점수가 0개일 때
			System.out.println(1);
		}
		
		else if(data[0]==1) {								//점수가 1개일 때
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
				score[i] = Long.parseLong(st.nextToken());		//first에는 원본 데이터가
				first+=score[i];					//score배열에는 원본데이터가 
			}
			
			pq.add((long) data[1]);
			for(int i=0; i<data[0]; i++) {
				pq.add(score[i]);
				if(score[i]==0) break;
			}
			
			long[] score2 = new long[(int) (data[0]+1)];
			
			int k =0;
			if(data[2]==data[0]) {						//주어진 점수 개수와 랭킹 리스트 크기가 같을 때
				while(data[0]-- >0) {
					score2[k]=pq.remove();
					second+=score2[k];				//second에는 우선순위큐 넣어진 데이터가
					k++;						//score2배열에는 우선순위큐의 데이터가
				}
			}
			
			else {								// 다를때, 랭킹 리스트가 점수개수 보다 클 경우
				while(pq.size()>0) {					// 원본 데이터 사이즈보다 +1
					score2[k]=pq.remove();				// ex) 321    3210 or 3211
					second+=score2[k];
					k++;
				}
			}
			
			if(first.equals(second)) System.out.println(-1);		//전과 같다면 -1 출력 
			else {
				for(int i=0; i<score2.length;i++) {
					if(i==score2.length-1) {			//score2길이가 score보다 클수도있고 작을수도 있기에
						System.out.println(issame(score2,i)+1);
						break;
					}
					if(score[i]==score2[i]) {			//같으면 pass
						continue;
					}
					else {						//다르면 score2 배열과 달랐던 인덱스 i를 입력으로
						System.out.println(issame(score2,i)+1);
						break;
					}
				}
			}
		}
	}
	static int issame(long[] arr, int num) {					//달랐던 위치에서 몇개의 데이터가 같은것 있는지 확인
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
		if(rank==1 && arr[1]==arr[0]) {						//첫번째와 두번째 예외로 확인
			rank=0;
			answer = rank;
		}
		return answer;
	}
}
