package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[count];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int answer = 0;
		int start = 0;
		int end = count-1;
		int sum = arr[start] + arr[end];
		
		while(end != start) {
			if(sum==N) {				//sum == N
				answer++;
				if(end-start==1) break;
				end--;
				start++;
				sum = arr[end] + arr[start];
			}
			else if(sum > N) {			//sum > N 
				sum -= arr[end];
				end--;
				sum += arr[end];
			}
			else {						//sum < N 
				sum -= arr[start];
				start++;
				sum += arr[start];
			}
				
		}
		System.out.println(answer);
	}
}
