package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_14003 {
	static int N;
	static int[] A, index;
	static ArrayList<Integer> LIS;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		index = new int[N];
		LIS = new ArrayList<>();
		
		index[0] = 0;
		LIS.add(A[0]);
		
		for(int i=1 ; i<N ; i++) {
			// A[i]가 더 크면 그냥 추가 
			if(LIS.get(LIS.size() - 1) < A[i]) {
				LIS.add(A[i]);
				index[i] = LIS.size() - 1;
			} 
			// 그렇지 않을 경우 Lower Bound 이분탐색 진행 
			else {
				int idx = lowerbound(0, LIS.size() - 1, i);
				LIS.set(idx, A[i]);
				index[i] = idx; 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(LIS.size() + "\n");
		
		Stack<Integer> stack = new Stack<>();
		
		int findId = LIS.size() - 1;
		for(int i=N-1 ; i>=0 ; i--) {
			if(findId == index[i]) {
				findId--;
				stack.push(A[i]);
			}
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop() + " ");
		
		System.out.println(sb.toString());
	}
	public static int lowerbound(int L, int R, int idx){
        int mid;
        
        while(L < R){
            mid = (L + R) / 2;
            
            if(LIS.get(mid) < A[idx]) L = mid + 1;
            else R = mid; 
        }
        return L;
    }
}
