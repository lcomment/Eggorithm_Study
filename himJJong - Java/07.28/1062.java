package algorithm;
import java.io.*;
import java.util.*;;
 
public class plus {
	static int n,k;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	static String[] word;
	
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		sc.nextLine();
		word = new String[n];
		
		for(int i=0; i<n; i++) {			//입력받는 문자열에서 "anta","tica"는 같으니 빼고
			String str = sc.nextLine();		//남은것만 가져가 붙이기 
			str = str.replace("anta", "");
			str = str.replace("tica", "");
			word[i] = str;
		}
		
		if(k<5) {
			System.out.println("0");		// a t i n c 5개 이므로 이하는 0 
			return;
		}
		else if(k==26) {					// 모든 알파벳 다 읽기 가능 
			System.out.println(n);
			return;
		}
		
		visited = new boolean[26];			// a t i n c는 이미 제하고 생각해야 하니 true;
		visited ['a' - 'a'] = true;
		visited ['c' - 'a'] = true;
		visited ['i' - 'a'] = true;
		visited ['n' - 'a'] = true;
		visited ['t' - 'a'] = true;
		
		backtracking(0,0);
		System.out.println(max);
	}
	
	public static void backtracking(int alpha, int len) {
		if(len == k-5) {				    //len의 값 일때 
			int count = 0;
			for(int i=0; i<n ; i++) {		//n개의 문자열 개수만큼 for문을 돌릴건데  
				boolean read = true;
				for(int j=0; j<word[i].length(); j++) { // i번쨰 남은 문자열을 하나씩 검토해서  
					if(!visited[word[i].charAt(j)-'a']) {//여기서 false라는것은 visited[i]=true;
						read = false;					 //이게 실행되면 바깥에서는 false; 
						break;
					}
				}
				if(read) {								//그래서 남은 문자열이 true라서 count++; 
					count++;
			//		System.out.println("==========");
			//		System.out.println(alpha);
				}
			}
			max = Math.max(max, count);
			return;
		}
	
		for(int i=alpha; i<26 ;i++) {
			if(visited[i]==false) {		//브루트포스, 방문했는지 안했는지 하나씩 검토하다가 
				visited[i] = true;
				backtracking(i,len+1);  //(i는 알파벳 인덱스 - 1 , len값에 맞게)
				visited[i] = false;		//검사 완료후에 원래대로 false값 넣기 
			}
		}
	}
}
