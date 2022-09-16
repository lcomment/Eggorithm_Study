package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	static int n, m;
	static int[] a =new int[1001];
	static long[][] d =new long[1001][1002];
	static int minn=-1;
	
	public static void main(String args[]) throws IOException{
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		for (int i = 0; i < n; i++) {
			a[i]=scan.nextInt();
		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1002; j++) {    //초기화 
				d[i][j]=-1;
			}
		}
		System.out.println(go(0,0));
	}
	static long go(int i, int sum) {
		if(i==n) {	                        // 이름 개수 같으면 끝 
			return 0;
		}
		long ans=d[i][sum];
		if(ans!=-1) return ans;
		ans=0;
		if(sum+a[i]<=m) {                   // 이어가기 
			ans=go(i+1, sum+a[i]+1);
			ans=Math.min(ans, go(i+1, a[i]+1)+(m-sum+1)*(m-sum+1));
		}
		if(sum+a[i]>m) {                    // 칸 넘어가기 
			ans=go(i+1, a[i]+1)+(m-sum+1)*(m-sum+1);
		}
		d[i][sum]=ans;                      // 값 저장
		return ans;
	}
}
