package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1038 {
	static ArrayList<Long> reducedNums = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 10) System.out.println(N);
		
		else if(N > 1022) System.out.println(-1);
		
		else {
			for(int i=0 ; i<10 ; i++) {
				calReducedNum(i, 1);
			}
			
			Collections.sort(reducedNums);
			System.out.println(reducedNums.get(N)); 
		}
	}
	static void calReducedNum(long base, int idx) {
		if(idx > 10)
			return;
		
		reducedNums.add(base);
        for(int i = 0; i < base % 10; i++) {
        	calReducedNum((base * 10) + i, idx + 1);
        }
	}
}
