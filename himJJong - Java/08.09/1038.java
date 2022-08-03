
































/* 브루트포스로 하는 방법인거 같은데, 이렇게 하니 시간이 너무 오래걸린다.
package chapter2;

import java.util.*;
import java.io.*;

public class TypeInference{
	static boolean status;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;				// num과 값이 같아진다면 멈추게 할 변수 

		
		if(num<=10) {
			System.out.println(num);
		}
		else {
			count = 10;
			for(int i=11; i<Integer.MAX_VALUE;i++) {
				if(cal(i)) {
					count++;
				}
				else {
					continue;
				}
				if(count==num) {
					if(status==true) {
						System.out.println(i);
						break;
					}
					else {
						System.out.println(-1);
						break;
					}
					
				}
				
			}
		}
	}
	static boolean cal(int i) {
		String str = Integer.toString(i);
		String[] arr = str.split("");
		for(int j=0;j<arr.length-1;j++) {
			if(Integer.parseInt(arr[j])>Integer.parseInt(arr[j+1])) {
				status = true;
			}
			else {
				status = false;
				break;
			}
		}
		return status;
	}
}
*/
