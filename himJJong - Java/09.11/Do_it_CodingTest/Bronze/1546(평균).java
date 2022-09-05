import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		int[] arr = new int[count];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		
		for(int i=0; i<count ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		double aver = 0;	
		double[] newarr = new double[count];
		for(int i=0; i<count; i++) {
			if(arr[i]==max) {
				newarr[i] = (double)(arr[i]/max)*100;
			}
			else 
				newarr[i] = (double)(arr[i]*100)/max;
			
			aver += newarr[i];
		}
		System.out.println(aver/count);
	}
}
		
