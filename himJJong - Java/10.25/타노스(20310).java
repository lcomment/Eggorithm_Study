import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		int isok = 0;
		String str = sc.next();
		
		// 서브태스크 모두 만족 
		if(str.length()%4==0) {
			char[] array = new char[str.length()+1];
			for(int i=1; i<str.length();i++) {
				array[i] = str.charAt(0);
			}
			for(int i=1; i<=str.length(); i++) {
				if(i%2==0 && array[i]==0) {
					continue;
				}
				else if(i%2==1 && array[i]==1){
					continue;
				}
				else {
					isok=1;
					System.out.println(mul(str));
					break;
				}
			}
			if(isok==1) {
				
			}
			else {
				String temp = "";
				for(int i=0; i<str.length()/4; i++) {
					String temp2 = "01";
					temp += temp2;
				}
				System.out.println(temp);
			}
			
		}
		
		//문자열 길이가 4의 배수가 아닐 때 
		else {
			System.out.println(mul(str));
		}
	}
	static String mul(String arr) {
		String answer = "";
		int zero = 0;
		int one = 0 ;
		
		String[] arr1 = arr.split("");
		for(int i=0; i<arr.length(); i++) {
			if(Integer.parseInt(arr1[i])==0)	zero++;
			else if(Integer.parseInt(arr1[i])==1) one++;
		}
		zero /= 2;
		one /= 2;
		
		while(true) {
			for(int i=0; i<arr1.length; i++) {
				if(Integer.parseInt(arr1[i])==1) {
					arr1[i]="3";
					one--;
				}
				if(one==0) break;
			}
			
			for(int i=arr1.length-1; i>0; i--) {
				if(Integer.parseInt(arr1[i])==0) {
					arr1[i]="3";
					zero--;
				}
				if(zero==0) break;
			}
			if(zero==0 && one==0) break;
		}
		for(int i=0; i<arr1.length;i++) {
			if(Integer.parseInt(arr1[i])==3) continue;
			else answer+=arr1[i];
		}
		return answer;
	}
}
