package implementation;

// BOJ 14719 빗물 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());	// 세로 (세로 변수 안 쓴다고 주석 처리했다가 계속 오류났음 ㅋㅋㅋ)
		int W = Integer.parseInt(st.nextToken());	// 가로 
		
		int[] arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int leftMax;
		int rightMax;
		int max;
		int answer = 0;
		
		for(int i = 0; i < W; i++) {
			leftMax = 0;
			rightMax = 0;
			// 해당 인덱스의 왼쪽 부분 배열에서 가장 큰 값 찾기 
			for(int j = i; j >= 0; j--) {
				if(arr[j] > leftMax) leftMax = arr[j];
			}
			
			// 해당 인덱스의 오른쪽 부분 배열에서 가장 큰 값 찾기 
			for(int j = i; j < W; j++) {
				if(arr[j] > rightMax) rightMax = arr[j];
			}
			
			// 두 최대값 중 작은 값 구하기 
			max = Math.min(leftMax, rightMax);
			answer += Math.max(0, max - arr[i]);
		}

		System.out.println(answer);
	}
}

		
//		for(int i = 0; i < W; i++) {
//			M = Integer.parseInt(st.nextToken());
//			if(max < M) {
//				while(!stack.isEmpty()) {
//					sum += max - stack.pop();
//				}
//				max = M;
//			}else if(max == M) {
//				while(!stack.isEmpty()) {
//					sum += max - stack.pop();
//				}
//			}else {	// max < M
//				if(stack.isEmpty() || stack.peek() >= M) stack.add(M);
//				else if(stack.peek() < M) {
//					
//				}
//				
//				
//			}
//		}
		
