package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786 {
	static String str, find;
	static int[] table;
	static ArrayList<Integer> indexList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		find = br.readLine();
		table = new int[find.length()];
		
		makeTable(find.length());
		search(str.length(), find.length());
		
		System.out.println(indexList.size());
		
		for(int index : indexList)
			System.out.println(index);
	}
	static void makeTable(int len) {
		int idx = 0;
		
		for(int i=1 ; i<len ; i++) {
			while(idx > 0 && find.charAt(i) != find.charAt(idx))
				idx = table[idx-1];
			
			if(find.charAt(i) == find.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		} // for
	}
	static void search(int sLen, int fLen) {
		int idx = 0;
		
		for(int i=0 ; i<sLen ; i++) {
			while(idx > 0 && str.charAt(i) != find.charAt(idx))
				idx = table[idx-1];
			
			if(str.charAt(i) == find.charAt(idx)) {
				if(idx == fLen - 1) {
					indexList.add(i - idx + 1);
					idx = table[idx];
				}
				else
					idx++;
			}
		} // for
	}
}
