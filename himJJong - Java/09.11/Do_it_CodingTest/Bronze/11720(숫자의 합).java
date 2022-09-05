package chapter2;
import java.util.*;
import java.io.*;

public class TypeInference {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int answer = 0;
		String[] arr = new String[count];
		String text = sc.next();
		
		arr = text.split("");
		
		for(int i=0; i<count ; i++) {
			answer+=Integer.parseInt(arr[i]);
		}
		System.out.println(answer);
	}
}
		
