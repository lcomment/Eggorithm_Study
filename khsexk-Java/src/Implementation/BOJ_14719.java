package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14719 {
	static int r, c;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		 r = input[0];
		 c = input[1];
		 
		 int[] blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		 
		 // 블럭 체크 
		 for(int i=1 ; i<blocks.length-1 ; i++) {
			 int left = Integer.MIN_VALUE;
			 int right = Integer.MIN_VALUE;
			 
			 for(int j=0 ; j<i ; j++)
				 left = Math.max(blocks[j], left);
			 for(int j=i+1 ; j<blocks.length ; j++)
				 right = Math.max(blocks[j], right);
			 
			 System.out.println(left + " " + right);	 
			 
			 if(blocks[i] < left && blocks[i] < right) {
				 if(left < right) {
					 count += left - blocks[i];
				 } else {
					 count += right - blocks[i];
				 }
			 }
		 }
		 
		 System.out.println(count);	 
	}

}
