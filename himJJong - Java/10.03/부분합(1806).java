import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int[] arr= new int[N+1];
		int near = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		int sum =0;
		int start = 0;
		int end = 0;
		
		while(start <=N && end <=N) {
			if(sum >=goal && ans > end - start)
				ans = end -start;
			
			if(sum<goal)
				sum+= arr[end++];
			else sum -= arr[start++];
		}
		
		if(ans == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
	}
}
