package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14658 {
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, L, K;
	static Node[] stars;
	static int max = -1;
	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {-1, 1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NMLK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NMLK[0];
		M = NMLK[1];
		L = NMLK[2];
		K = NMLK[3];
		stars = new Node[K];
		
		for(int i=0 ; i<K ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			stars[i] = new Node(input[1], input[0]);
		}
		
		for(Node star1 : stars) {
			for(Node star2 : stars) {
				includeStar(star1.r, star2.c);
			}
		}
		
		System.out.println(K - max);
	}
	
	public static void includeStar(int r, int c) {
		int cnt = 0;
		
		for(Node star : stars) {
			if(r<=star.r && star.r<=r+L && c<=star.c && star.c<=c+L)
				cnt++;
		}

		max = Math.max(cnt, max);
	}
	
//	public static void includeStar(Node standard) {
//		for(int i=0 ; i<4 ; i++) {
//			int nr = standard.r + L * dr[i];
//			int nc = standard.c + L * dc[i];
//			
//			if(nr<0 || nc<0 || nr>M || nc>N) continue;
//			
//			int cnt = 0;
//			if(i==0) {
//				for(Node s : star) {
//					if(nr<=s.r && s.r<=standard.r && nc<=s.c && s.c<=standard.c) cnt++;
//				}
//			} else if(i==1) {
//				for(Node s : star) {
//					if(nr<=s.r && s.r<=standard.r && standard.c<=s.c && s.c<=nc) cnt++;
//				}
//			} else if(i==2) {
//				for(Node s : star) {
//					if(standard.r<=s.r && s.r<=nr && nc<=s.c && s.c<=standard.c) cnt++;
//				}
//			} else if(i==3) {
//				for(Node s : star) {
//					if(standard.r<=s.r && s.r<=nr && standard.c<=s.c && s.c<=nc) cnt++;
//				}
//			} 
//			System.out.println(cnt);
//			max = Math.max(cnt, max);
//		} // for_i
//	}
}
