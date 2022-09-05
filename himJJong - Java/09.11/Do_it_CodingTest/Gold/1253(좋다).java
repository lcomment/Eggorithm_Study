package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	static int count;
	static long[] arr;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		count = Integer.parseInt(br.readLine());
		arr = new long[count];
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<count; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<count; i++) {
			long find = arr[i];
			int start = 0;
			int end = count-1;
			while(start < end) {
				if(arr[start]+arr[end]==find) {
					if(start!=i && end!=i) {
						answer++;
						break;
					}
					else if(start==i) {
						start++;
					}
					else if(end==i) {
						end--;
					}
				}
				else if(arr[start]+arr[end]<find) {
					start++;
				}
				else end--;
			}
		}
		System.out.println(answer);
	}
}
