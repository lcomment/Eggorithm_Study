package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_9375 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(N-- > 0) {
			Map<String, Integer> clothes = new HashMap<>();
			int kind = Integer.parseInt(br.readLine());
			
			for(int i=0; i<kind ; i++) {
				String[] input = br.readLine().split(" ");
				
				if(!clothes.containsKey(input[1])) {
					clothes.put(input[1], 1);
					continue;
				}
				clothes.replace(input[1], clothes.get(input[1]) + 1);
			}
			int result = 1;
			
			for(String c : clothes.keySet()) 
				result *= clothes.get(c) + 1;
			
			sb.append(result-1 + "\n");
		} // while
		
		System.out.println(sb.toString());
	}

}
