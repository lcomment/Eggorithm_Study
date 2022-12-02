package String;

import java.io.*;
import java.util.Arrays;

public class BOJ_1427 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s= br.readLine();
		
		char cArr[] = s.toCharArray();
		
		Arrays.sort(cArr);
		
		String result = "";
		
		for(int i=cArr.length-1 ; i >=0 ; i--)
			result += cArr[i];
		
		System.out.println(result);
	}

}
