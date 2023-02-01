package yongshub-python.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int maxValue = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxValue = Math.max(arr[i], maxValue);
		}
		
		Arrays.sort(arr); // 오름차순 정렬
		for(int i = 0; i < N; i++) {
			double minValue = maxValue;
			int cnt = N - i;
			for(int j = i; j < cnt * 10001; j++) {
				if((minValue / cnt) > arr[i]) {
					break;
				}
				minValue++;
			}
			maxValue = (int) Math.max(maxValue, minValue - 1);
		}
		System.out.println(maxValue);
	}

}