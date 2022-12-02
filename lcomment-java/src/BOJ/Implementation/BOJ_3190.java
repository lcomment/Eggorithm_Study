package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_3190 {
	static class Node {
		int r, c;
		int d;  // 0: 상, 1: 하, 2: 좌, 3: 우 
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
		Node(int r, int c, int d){
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static int N, K, L;
	static int[][] map;
	static ArrayList<Node> apples;
	static Deque<Node> snake;
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static String[][] cmds;
	static int second = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		apples = new ArrayList<>();
		
		for(int i=0 ; i<K ; i++) {
			int[] apple = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			apples.add(new Node(apple[0]-1, apple[1]-1));
		}
		
		snake = new LinkedList<>();
		snake.offer(new Node(0, 0, 3));
		L = Integer.parseInt(br.readLine());
		cmds = new String[L][2];
		
		for(int i=0 ; i<L ; i++) {
			cmds[i] = br.readLine().split(" ");
		}
		
		boolean isMoved = false;
		
		Loop:
		for(String[] cmd : cmds) {
			int sec = Integer.parseInt(cmd[0]) - second;
			for(int j=0 ; j<sec ; j++) {
				isMoved = move();
				
				if(!isMoved) break Loop;
				
			}
			
			
			int change = 0;
			int d = snake.peekFirst().d;
			
			if(cmd[1].equals("L")) {
				change = d + 1;
				if(change == 4) {
					change = 0;
				}
			}
			else if(cmd[1].equals("D")) {
				change = d - 1;
				if(change == -1) {
					change = 3;
				}
			}
			changeDir(change);
		}
		
		if(isMoved) {
			while(true) {
				if(!move())
					break;
			}
		}
		
		System.out.println(second);
	}
	static boolean move() {
		Node n = snake.pollFirst();
		second++;
		int nr = n.r + dir[n.d][0];
		int nc = n.c + dir[n.d][1];
			
		// 벽 밖으로 나감 
		if(nr<0 || nc<0 || nr>N-1 || nc>N-1) return false;
			
		// 자기 몸 포함 
		for(Node conquer : snake) 
			if(conquer.r == nr && conquer.c == nc) return false;
			
		
		
		if(checkApple(nr, nc)) {
			snake.offerFirst(n);
			snake.offerFirst(new Node(nr, nc, n.d));
		}
		else {
			snake.offerFirst(n);
			snake.offerFirst(new Node(nr, nc, n.d));
			snake.pollLast();
		} 
		
//		System.out.println(second);
//		for(Node sn : snake)
//			System.out.println(sn.r + " " + sn.c + " " + sn.d);
//		
//		System.out.println();
		return true;
	}
	static void changeDir(int direction) {
		for(Node conquer : snake) {
			conquer.d = direction;
		}
//		System.out.println(snake.peek().d+"\n");
	}
	static boolean checkApple(int r, int c) {
		int len = apples.size();
		for(int i=0 ; i<len; i++) {
			Node apple = apples.get(i);
			
			if(apple.r == r && apple.c == c) {
				apples.remove(i);
				return true;
			}
		}
		return false;
	}
}
