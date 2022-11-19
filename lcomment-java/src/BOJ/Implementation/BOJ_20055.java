package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_20055 {
	static int N, K;
	static int[] A;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NK[0];
		K = NK[1];
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		robot = new boolean[N];
		
		int count = 0;
		while(K > countZero()) {
			step1();
			step2();
			step3();
			
			count++;
		}
		
		System.out.println(count);
		
	}
	// 1. 회전 
	static void step1() {
		int save1 = A[0];
		int save2 = 0;
		boolean rSave1 = robot[0];
		boolean rSave2 = false;
		
		for(int i=1 ; i<2*N ; i++) {
			save2 = A[i];
			A[i] = save1;
			save1 = save2;
			
			if(i<N) {
				rSave2 = robot[i];
				robot[i] = rSave1;
				rSave1 = rSave2;
			}
		}
		A[0] = save1;
		robot[0] = false;
	}
	// 2. 이동 
	static void step2() {
		robot[N-1] = false;
        for (int i = N-1; i > 0; i--) {   
            if (robot[i-1] && !robot[i] && A[i] != 0) {
                robot[i] = true;
                robot[i-1] = false;
                A[i]--;
            }
        }
	}
	// 3. 추가 
	static void step3() {
		if(A[0] != 0) {
			A[0]--;
			robot[0] = true;
		}
	}
	// 4. 0 세기 
	static int countZero() {
		int zero = 0;
		for(int i : A) {
			if(i == 0)
				zero++;
		}
		return zero;
	}
}
