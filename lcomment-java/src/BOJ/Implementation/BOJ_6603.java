package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ_6603 {
	static int k;
	static ArrayList<ArrayList<Integer>> inputCase = new ArrayList<>();
	static boolean c[]; static int a[];
	static ArrayList<Integer> resultCase = new ArrayList<>();
	static HashMap<Integer, boolean[]> visited = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int index = 0;
		while(true) {
			String[] input = br.readLine().split(" ");
			
			if(input[0].equals("0"))
				break;
			
			visited.put(index, new boolean[Integer.parseInt(input[0])]);
			
			for(int i=1 ; i<=Integer.parseInt(input[0]) ; i++) {
				inputCase.add(new ArrayList<Integer>());
				inputCase.get(index).add(Integer.parseInt(input[i]));
			}
			index++;
		}
		
		// 백트래킹 
		for(int i=0 ; i<inputCase.size(); i++) {
			backTracking(i, 0, 0);
			System.out.println();
		}
	}
	public static void backTracking(int seq, int start, int depth) {
		if(depth == 6) {
			for(int i=0 ; i<inputCase.get(seq).size() ; i++) {
				if(visited.get(seq)[i])
					System.out.print(inputCase.get(seq).get(i) + " ");
			}
			System.out.println();
			return;
		}
		for(int j=start ; j<inputCase.get(seq).size() ; j++) {
			if(visited.get(seq)[j]) continue;
			
			visited.get(seq)[j] = true;
			backTracking(seq, j, depth+1);
			visited.get(seq)[j] = false;
		}
	} // 백트래킹 
}
