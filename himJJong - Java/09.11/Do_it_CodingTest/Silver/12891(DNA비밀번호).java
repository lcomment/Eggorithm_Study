package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		int count = Integer.parseInt(st.nextToken());
		int part = Integer.parseInt(st.nextToken());	
		
		char A[] = new char[count];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;
		
		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i]==0) {
				checkSecret++;
			}
		}
		for(int i=0; i<part; i++) {
			Add(A[i]);
		}
		if(checkSecret==4)	answer++;
		
		for(int i=part; i<count; i++) {
			int j = i-part;
			Add(A[i]);
			Remove(A[j]);
			if(checkSecret==4) answer++;
		}
		System.out.println(answer);
	}
	
	static void Add(char c) {
		switch(c) {
		case'A':
			myArr[0]++;
			if(myArr[0]==checkArr[0])
				checkSecret++;
			break;
		case'C':
			myArr[1]++;
			if(myArr[1]==checkArr[1])
				checkSecret++;
			break;
		case'G':
			myArr[2]++;
			if(myArr[2]==checkArr[2])
				checkSecret++;
			break;
		case'T':
			myArr[3]++;
			if(myArr[3]==checkArr[3])
				checkSecret++;
			break;
			}
	}
	
	static void Remove(char c) {
		switch(c) {
		case'A':
			if(myArr[0]==checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
		case'C':
			if(myArr[1]==checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case'G':
			if(myArr[2]==checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case'T':
			if(myArr[3]==checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
	}
}
}

/* 시간초과
package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	static int[] dnacount;
	static int[] save;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		int count = Integer.parseInt(st.nextToken());	//dna 개수 
		int part = Integer.parseInt(st.nextToken());	//자를 part 크기 값 
		
		String dna = br.readLine();				//입력받을 내용 
		String[] dnarr = dna.split("");			//.split으로 나눈 하나씩의 String 배열
		save = new int[4];
		
		dnacount = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			dnacount[i] = Integer.parseInt(st.nextToken());		// 포함되어야 할 dna 개수를 배열로 
			save[i] = dnacount[i];
		}
		
		for(int i=0; i<count-part+1;i++) {		//검사시작 
			if(isok(dna.substring(i, part+i))) {
				answer++;
			}
			isnew();							//dnacount[0] = a , dnacount[1] = c
		}										//dnacount[2] = g , dnacount[3] = t
		System.out.println(answer);
	}
	static boolean isok(String text) {
		String[] arr = text.split("");
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("A")) {
				if(dnacount[0]>0) {
					dnacount[0]--;
				}
			}
			else if(arr[i].equals("C")) {
				if(dnacount[1]>0) {
					dnacount[1]--;
				}
				
			}
			else if(arr[i].equals("G")) {
				if(dnacount[2]>0) {
					dnacount[2]--;
				}
			}
			else if(arr[i].equals("T")) {
				if(dnacount[3]>0) {
					dnacount[3]--;
				}
			}
			if(dnacount[0]==0 && dnacount[1]==0 && dnacount[2]==0 && dnacount[3]==0) {
				return true;
			}
		}
		return false;
	}
	static void isnew() {
		for(int i=0; i<4; i++) {
			dnacount[i] = save[i];
		}
	}
}
*/
