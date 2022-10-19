package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1244 {
	static final int ON = 1, OFF = 0;
	
	static int N, M;
	static int[] svvitch;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		svvitch = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		M = Integer.parseInt(br.readLine());
		
		while(M-- > 0) {
			int[] student = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(student[0] == 1) {
				pn(student[1]);
			} else {
				ps(student[1]-1);
			}
		} // while-M
		
		for(int i=0 ; i<svvitch.length ; i++) {
			System.out.print(svvitch[i] + " ");
			
			if((i + 1) % 20 == 0)
				System.out.println();
		}
	}
	
	public static void pn(int standard) {
		for(int i=1 ; standard*i<=svvitch.length ; i++) {
			changeStatus(standard*i - 1);
		}
	}
	
	public static void ps(int standard) {
		int idxDown = standard -1;
		int idxUp = standard + 1;
		
		while(true) {
			if((idxDown<0 || idxUp>N-1) || (svvitch[idxDown] != svvitch[idxUp])) {
				idxDown++;
				idxUp--;
				break;
			}
			idxDown--;
			idxUp++;
		}
		
		if(idxDown == idxUp) {
			changeStatus(standard);
		} else {
			for(int i=idxDown ; i<=idxUp ; i++) {
				changeStatus(i);
			}
		}
	}
	
	public static void changeStatus(int idx) {
		if(svvitch[idx] == ON)  svvitch[idx] = OFF;
		else  svvitch[idx] = ON;
	}
}
