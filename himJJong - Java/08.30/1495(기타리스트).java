package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		int ans = -1;
		int[] vol = new int[limit+1];
		int[] change = new int[count+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<count ; i++) {
			change[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<limit+1; i++) {
			vol[i] = -1;                   // 초기화 
		}
		
		vol[start] = 0;
		
		for(int i=1; i<count+1; i++) {	// 볼륨개수 
			List<Integer> changer = new ArrayList<>();		//유효범위 담을 changer
			for(int j=0; j<limit+1; j++) {
				if(vol[j]==i-1) {                   // 0~limit 범위까지 깊이가 같을 때 범위내에 든다면 
					int minus = j - change[i-1];
					int plus = j + change[i-1];
					
					if(minus>=0) {
						changer.add(minus);
					}
					if(plus<=limit) {
						changer.add(plus);
					}
				}
			}
			for(int k : changer) vol[k] = i;     // 해당 vol값만 i의 깊이로 초기화.
		}
		for(int i=0; i<limit+1; i++) {          // 다 돌면 마지막 vol값과 같은 깊이를 가진 최대값을 ans에 저장하고 없다면 그대로 -1이 나오게 된다.
			if(vol[i]==count) {
				ans = Math.max(ans,i);
			}
		}
		System.out.println(ans);
	}
}
