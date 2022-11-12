package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_8979 {
	static class Nation implements Comparable<Nation>{
		int id, gold, silver, iron;
		
		Nation(int id, int gold, int silver, int iron){
			this.id = id;
			this.gold = gold;
			this.silver = silver;
			this.iron = iron;
		}
		
		@Override
		public int compareTo(Nation n) {
			int g = n.gold - this.gold;
			if(g != 0) return g;
			
			int s = n.silver - this.silver;
			if(s != 0) return s;
			
			int i = n.iron - this.iron;

			return i;
		}
	}
	
	static int N, K;
	static Nation[] nations;
	static int rank = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NK[0];
		K = NK[1];
		nations = new Nation[N];
		
		for(int i=0 ; i<N ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			nations[i] = new Nation(input[0], input[1], input[2], input[3]);
		}
		
		Arrays.sort(nations);
		
		int rank = 1;
		int cnt = 1;
		
		if(nations[0].id == K) {
		    System.out.println(rank);
		    return;
		}
		
		for(int i=1 ; i<N ; i++) {
            Nation n1 = nations[i-1];
            Nation n2 = nations[i];
            
            if(checkSameScore(n1, n2)){
                cnt++;
            } else{
                rank += cnt;
                cnt = 1;
            }
            
            if(n2.id == K)
                break;
		}
		
		System.out.println(rank);
	}
	
	static boolean checkSameScore(Nation n1, Nation n2){
	    if(n1.gold == n2.gold && n1.silver == n2.silver && n1.iron == n2.iron) return true;
	    return false;
	}
}

