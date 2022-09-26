import java.util.*;
import java.io.*;

public class Main {
	static long answer;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(st.nextToken());
		int howmany = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[count];
		long[] sumarr = new long[count];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<count ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sumarr[0] = arr[0];
		
		for(int i=1; i<count; i++) {
		
			sumarr[i] = sumarr[i-1]+arr[i];
		}
		
		int[] street = new int[2];
		while(howmany -->0) {
			st = new StringTokenizer(br.readLine());
			int sub = 0;
			for(int i=0; i<2; i++) {
				street[i] = Integer.parseInt(st.nextToken());
			}
			if(street[0]==1) {
				answer = sumarr[street[1]-1];
			}
			else {
				answer = sumarr[street[1]-1]-sumarr[street[0]-2];
			}
			
			sb.append(answer);
			sb.append("\n");
			answer = 0;
		}
		
		System.out.println(sb);
	}
}
