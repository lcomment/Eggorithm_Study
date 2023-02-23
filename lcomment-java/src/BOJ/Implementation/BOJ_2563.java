package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_2563 {
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N;
	static ArrayList<Node> existList = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = stoi(br.readLine());
        
        while(N-- > 0) {
        	int[] input = sToIntArray(br.readLine());
        	
        	// 입력 받은 칸 기준으로 10x10
        	for(int r=input[0] ; r<input[0]+10 ; r++) {
        		for(int c=input[1] ; c<input[1]+10 ; c++) {
        			Node node = new Node(r, c);
                	if(checkExist(node)) {
                		existList.add(node);
                	}
        		}
        	}
        }
        
        System.out.println(existList.size());
    }
    
    // 이미 포함시킨 칸인지 체크
    private static boolean checkExist(Node node) {
    	for(Node n : existList) {
    		if(n.r == node.r && n.c == node.c) 
    			return false;
    	}
    	return true;
    }
    
    private static int stoi(String s) {
    	return Integer.parseInt(s);
    }
    
    private static int[] sToIntArray(String s) {
    	return Arrays.stream(s.split(" "))
    			.mapToInt(Integer::parseInt)
    			.toArray();
    }
}
