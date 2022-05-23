package BOJ;

import java.io.*;

public class BOJ_2531 {
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int d = Integer.parseInt(s[1]);
		int k = Integer.parseInt(s[2]);
		int c = Integer.parseInt(s[3]);
		
		int[] sushi = new int[N];
		
		
		for(int i=0 ; i<N ; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			boolean[] eatedSushi = new boolean[d+1];
			int cnt = 0;
			int idx = i;
			int sum = 0;
			
			while(cnt++ < k) {
				if(!eatedSushi[sushi[idx]]) sum++;
				eatedSushi[sushi[idx]] = true;
				if(idx == N-1) idx = 0;
				else idx++;
			}
			if(!eatedSushi[c]) sum ++;
			
			max = (sum > max) ? sum:max;
		} // for_i
		
		System.out.println(max);
	}

}
