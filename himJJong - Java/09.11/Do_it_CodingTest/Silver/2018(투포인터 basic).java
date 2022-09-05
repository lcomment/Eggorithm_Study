package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int answer = 1;
		int start = 1;
		int end = 1;
		int sum = 1;
		
		while(end !=N) {
			if(sum==N) {
				answer++;
				end++;
				sum = sum + end;
			}
			else if(sum > N) {
				sum = sum - start;
				start++;
			}
			else {
				end++;
				sum = sum + end;
			}
		}
		System.out.println(answer);
	}
}
