package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7795 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s;
		
		
		for(int i=0 ; i<N ; i++) {
			String[] NM = br.readLine().split(" ");
			
			int[] A = new int[Integer.parseInt(NM[0])];
			int[] B = new int[Integer.parseInt(NM[1])];
			
			s = br.readLine().split(" ");
			for(int j=0 ; j<A.length ; j++)
				A[j] = Integer.parseInt(s[j]);
			
			s = br.readLine().split(" ");
			for(int j=0 ; j<B.length ; j++)
				B[j] = Integer.parseInt(s[j]);
			
			int cnt = 0;
			Arrays.sort(A);
			Arrays.sort(B);
			
			for(int j=0 ; j<A.length ; j++) {
				int point = 0;
				while(point<B.length && A[j]>B[point])
					point++;
				cnt += point;
			}
			System.out.println(cnt);
		}
	}
}
