package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2812 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int K = Integer.parseInt(input[1]);
		
		String num = br.readLine();
		StringBuilder sb = new StringBuilder(num);
		int length = num.length() - K;
		
		int idx = 1;
		while(K>0 && idx != sb.length()) {
			if(sb.charAt(idx-1) < sb.charAt(idx)) {
				if(idx == 1) 
					sb.deleteCharAt(0);
				else {
					sb.deleteCharAt(idx-1);
					idx--;
				}
				K--;
			}
			else
				idx++;

			//bw.write(Integer.toString(idx) + " "+ sb.toString() + "\n");
		}
		if(sb.length() > length) {
			//bw.write();
			bw.write(sb.substring(0, length));
			sb.setLength(0);
			//System.out.println();

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}