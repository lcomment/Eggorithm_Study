package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_10431 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			sb.append(input[0] + " ");
			
			ArrayList<Integer> seq = new ArrayList<>();
			for(int i=1 ; i<=20 ; i++) seq.add(input[i]);		
			
			int sum = 0;
			for(int i=0 ; i<20 ; i++) {
				int cur = seq.get(i);
				for(int j=0 ; j<i ; j++) {
					int compare = seq.get(j);
					
					if(compare > cur) {
						sum++;
					}
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}

}
