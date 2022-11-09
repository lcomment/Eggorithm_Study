package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] map;
	static ArrayList<Node> chicken = new ArrayList<>();
	static ArrayList<Node> person = new ArrayList<>();
	static int N, M;
	static int[][] dist;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = NM[0];
		M = NM[1];
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
 
                if (map[i][j] == 1) {
                    person.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
		}
		backtracking(chicken.size(), new boolean[chicken.size()], 0, 0);
		System.out.println(result);
	}
	
	static void backtracking(int n, boolean[] select, int depth, int idx) {
		if(depth == M) {
			int res = 0;
			 
            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;
 
                for (int j = 0; j < chicken.size(); j++) {
                    if (select[j]) {
                        int distance = Math.abs(person.get(i).r - chicken.get(j).r)
                                + Math.abs(person.get(i).c - chicken.get(j).c);
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            result = Math.min(result, res);
			return;
		}
		
		for(int i=idx ; i<n ; i++) {
			if(select[i]) continue;
			
			select[i] = true;
			backtracking(n, select, depth + 1, i + 1);
			select[i] = false;
		}
	}
}
