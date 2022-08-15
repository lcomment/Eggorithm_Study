package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1759 {
	static int L, C;
	static String[] alphabet;
	static boolean[] visited;
	static ArrayList<String> mo = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		L = input[0];
		C = input[1];
		
		alphabet = br.readLine().split(" ");
		Arrays.sort(alphabet);
		
		visited = new boolean[C];
		mo.add("a");
		mo.add("i");
		mo.add("u");
		mo.add("e");
		mo.add("o");
		
		combination(0, 0);
	}
	
	static void combination(int start, int depth) {
		if(depth == L) {
//			System.out.println(1);
			print(visited);
			return;
		}
		
		for(int i=start ; i<visited.length ; i++) {
			visited[i] = true;
			combination(i + 1, depth + 1);
			visited[i] = false;
		}
	}
	
	static void print(boolean[] visited) {
		StringBuilder sb = new StringBuilder();
		int j=0, m=0;
		
		for(int i=0 ; i<visited.length ; i++) {
			if(visited[i]) {
				if(mo.contains(alphabet[i])) {
					sb.append(alphabet[i]);
					m++;
				} else {
					sb.append(alphabet[i]);
					j++;
				}
				
			}
				
		}
		if(m > 0 && j > 1)
			System.out.println(sb.toString());
	}
}
