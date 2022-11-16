package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_22233 {
	static int N, M;
	static Set<String> keyword = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = NM[0];
		M = NM[1];
		
		for(int i=0 ; i<N ; i++) {
			keyword.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<M ; i++) {
			String[] contents = br.readLine().split(",");
			
			for(String content : contents) {
				keyword.remove(content);
			}
			sb.append(keyword.size() + "\n");
		}
		System.out.println(sb.toString());
	}

}
