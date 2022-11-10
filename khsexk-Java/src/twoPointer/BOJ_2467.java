package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 범위: -1,000,000,000 ~ 1,000,000,000 -> int로 충분 
// 투포인터 사용시 O(N) 
public class BOJ_2467 {
	static int N;
	static int[] seq;
	static int min = Integer.MAX_VALUE;
	static int[] save = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
//		Arrays.sort(seq);  이미 정렬된 상태로 입력됨 
		
		int start = 0;
		int end = seq.length - 1;

		while(start < end) {
			int cur = seq[start] + seq[end];
			int curRes = Math.abs(cur);
			
			// 두 개 이상일 경우는 아무거나 출력해도 됨 -> 예제 출력2처럼 나오려면 <=를 넣어면 됨 
			if(curRes < min) {
				min = curRes;
				save[0] = seq[start];
				save[1] = seq[end];
			} 
			
			// seq[end]는 양수이면서 절댓값이 seq[start]보다 큼 
			if(cur >= 0) {
				end--;
			} else {
				start++;
			}
		} // while
		
		System.out.println(save[0] + " " + save[1]);
	}
	
}
