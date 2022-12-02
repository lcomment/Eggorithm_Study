package twoPointer;

import java.io.*;
import java.util.Arrays;

public class BOJ_3649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while((s = br.readLine()) != null) {
			int x = Integer.parseInt(s) * 10000000;
			int n = Integer.parseInt(br.readLine());
			
			int[] legoList = new int[n];
			//boolean[] usedLego = new boolean[100000001];
			
			for(int i=0 ; i<n ; i++) {
				legoList[i] = Integer.parseInt(br.readLine());
				//usedLego[legoList[i]] = true;
			}
			Arrays.sort(legoList);
			
			int start = 0;
			int end = n-1;
			boolean flag = false;

			// table 이용 
//			for(int i=0 ; i<n ; i++) {
//				int sub = x - legoList[i];
//				if(usedLego[sub] == true) {
//					System.out.println("yes " + legoList[i] + " " + sub);
//					flag = true;
//					break;
//				} // if
//			} // for_i
//			if(!flag)
//				System.out.println("danger");
			
			while(start<end) {
				int sum = legoList[start] + legoList[end];
				
				if(sum == x) {
					flag = true;
					break;
				}
				else if(sum < x)
					start++;
				else
					end--;
			} // while
			
			if(flag)
				System.out.println("yes " + legoList[start] + " " + legoList[end]);
			else
				System.out.println("danger");
		}
	}
}