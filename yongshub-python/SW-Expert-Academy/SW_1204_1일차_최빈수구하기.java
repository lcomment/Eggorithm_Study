import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	static int[] visited;
	static int maxIndex = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		int num;
		
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++) {
			num = Integer.parseInt(br.readLine());
			visited = new int[101];
			
			Arrays.stream(br.readLine()
					.split(" "))
					.mapToInt(Integer::parseInt)
					.forEach(e -> checkValue(e));
			System.out.printf("#%d %d\n", num, maxIndex);
		}
		
	}
	
	public static void checkValue(int num) {
		visited[num]++;
		if(visited[maxIndex] <= visited[num]) {
			maxIndex = num;
		}
	}
}
