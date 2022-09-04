import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		String[] arr = new String[count];
		for(int i=0; i<count ; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr);
		
		int answer = 0;
		int iscorrect = 0;
		int[] line;
		for(int i=0; i<count; i++) {
			iscorrect=0;
			for(int j=i+1; j<count; j++) {
				if(!iscontain(arr[i],arr[j])) {
					iscorrect+=1;
				}
			}
			if(iscorrect==count-(i+1)) {
				answer+=1;
			}
		}
		System.out.println(answer);
		
	}
	static boolean iscontain(String arr1, String arr2) {
		String[] ar1 = arr1.split("");
		String[] ar2 = arr2.split("");
		
		for(int i=0 ;i<ar1.length; i++) {
			if(ar1[i].equals(ar2[i])) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
