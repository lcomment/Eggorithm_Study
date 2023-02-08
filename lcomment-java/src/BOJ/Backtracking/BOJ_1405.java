package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/*
 * 예제 4번
 * 1.220703125E-4  <- 이렇게 출력되는데 정답처리됨
 * Java라서 그런가봄 (사실 0.0001220703125나 1.220703125E-4나 같긴 한데,,)
 */
public class BOJ_1405 {
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int move;
	static double percentage = 0.0;
	static double[] EWSN = new double[4];
	static int[][] moving = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static ArrayList<Node> visitedNode = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        init(sToDoubleArray(br.readLine()));
        visitedNode.add(new Node(0, 0));
        
        
        backtracking(1.0, 0);
        System.out.println(percentage);
    }

    private static void backtracking(double per, int cnt) {
    	// 다 움직였으면 확률 더해줌
    	if(cnt == move) {
    		percentage += per;
    		return;
    	}
    	
    	for(int i=0 ; i<moving.length ; i++) {
    		// 못 움직이는 방향은 넘김
    		if(EWSN[i] == 0) continue;
    		
    		int r = visitedNode.get(visitedNode.size() - 1).r + moving[i][0];
    		int c = visitedNode.get(visitedNode.size() - 1).c + moving[i][1];
    		
    		// 이미 밟은 노드면 넘김
    		if(!checkSimplePath(r, c)) continue;
    		
    		visitedNode.add(new Node(r, c));
    		backtracking(per * EWSN[i], cnt+1);
    		visitedNode.remove(visitedNode.size() - 1);
    	}
    }
    
    private static boolean checkSimplePath(int r, int c) {
    	for(Node node : visitedNode) {
    		if(r == node.r && c == node.c) return false;
    	}
    	return true;
    }
    
    private static void init(double[] input) {
    	move = (int) input[0];
    	EWSN[0] = input[1] / 100;
    	EWSN[1] = input[2] / 100;
    	EWSN[2] = input[3] / 100;
    	EWSN[3] = input[4] / 100;
    }
    
    private static double[]  sToDoubleArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
