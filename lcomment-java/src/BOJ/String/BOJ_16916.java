package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916 {
	static int[] table;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = br.readLine();
    	String find = br.readLine();
    	
    	makeTable(find);
    	
    	System.out.println(search(str, find));
    }
    
    public static void makeTable(String pattern) {
		int len = pattern.length();
		table = new int[len];
		
		int index = 0;
		for(int i = 1; i < len; i++) {
			while(index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
				index = table[index - 1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(index)) {
				index += 1;
				table[i] = index;  
			}
		}
 	}
    
    public static int search(String str, String pattern) {
    	int sLen = str.length();
    	int pLen = pattern.length();
    	
    	int index = 0;
    	for(int i = 0; i < sLen; i++) {
    		while(index > 0 && str.charAt(i) != pattern.charAt(index)) {
    			index = table[index - 1];
    		}
    		
    		if(str.charAt(i) == pattern.charAt(index)) {
    			if(index == pLen - 1) {
    				index = table[index];
    				return 1;
    			}
    			else {
    				index++;
    			}
    		}
    	}
    	return 0;
    }
    
}