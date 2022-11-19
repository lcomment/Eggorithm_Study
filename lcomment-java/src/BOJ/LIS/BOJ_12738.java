package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12738 {
	static int N;
	static int[] A;
	static int[] LIS;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		LIS = new int[N];
		
		int lisIdx = 1;
		LIS[0] = A[0];
		
		for(int i=1 ; i<N ; i++) {
			// A[i]가 더 크면 그냥 추가 
			if(LIS[lisIdx - 1] < A[i]) {
				lisIdx++;
				LIS[lisIdx - 1] = A[i];
			} 
			// 그렇지 않을 경우 Lower Bound 이분탐색 진행 
			else {
				int idx = lowerbound(0, lisIdx, A[i]);
				LIS[idx] = A[i];
			}
		}
		System.out.println(lisIdx);
		for(int i:LIS)
			System.out.print(i + " ");
	}
	public static int lowerbound(int L, int R, int n){
        int mid = 0;
        
        while(L < R){
            mid = (L + R) / 2;
            
            if(LIS[mid] < n) L = mid + 1;
            else R = mid; 
        }
        return L;
    }
}
