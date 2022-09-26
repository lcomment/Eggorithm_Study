package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	static int count;
	static int[] dis;
	static int[] diff;
	static String answer = "권병장님, 중대장님이 찾으십니다";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		count = Integer.parseInt(br.readLine());	// 몇명인지 
		dis = new int[count];
		diff = new int[count-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<count ; i++) {					// 사람들 위치 
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		if(count<=1) {
			System.out.println(answer);
		}
		else {
			int[] strong = new int[count-1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<count-1; i++) {					// 각자 힘 
				strong[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			
			for(int i=0; i<count-1; i++) {
				sum = Math.max(sum,dis[i]+strong[i]);
				if(sum>=dis[i+1]) {
				}
				else {
					answer = "엄마 나 전역 늦어질 것 같아";
					System.out.println(answer);
					return;
				}
			}
			System.out.println(answer);
		}
	}
}










/* 60%에서 안올라간 코드
package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	static int count;
	static int[] dis;
	static int[] diff;
	static String answer = "권병장님, 중대장님이 찾으십니다";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		count = Integer.parseInt(br.readLine());	// 몇명인지 
		dis = new int[count];
		diff = new int[count-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<count ; i++) {					// 사람들 위치 
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<count-1; i++) {
			diff[i] = dis[i+1]-dis[i];
		}
		
		if(count<=1) {
			System.out.println(answer);
		}
		else {
			int[] strong = new int[count-1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<count-1; i++) {					// 각자 힘 
				strong[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(diff);
			Arrays.sort(strong);
			
			for(int i=0; i<count-1; i++) {
				if(strong[i]>=diff[i]) {
					
				}
				else {
					answer = "엄마 나 전역 늦어질 것 같아";
					System.out.println(answer);
					return;
				}
			}
			System.out.println(answer);
		}
	}
}
*/
