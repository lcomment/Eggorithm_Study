package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_13904 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, ArrayList<Integer>> tasks = new HashMap<>();
		
		int max = 0;
		for(int i=0 ; i<N ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			max = input[0]>max ? input[0]:max;
			if(!tasks.containsKey(input[0]))
				tasks.put(input[0], new ArrayList<>());
			tasks.get(input[0]).add(input[1]);
		}
		
		int[] completed = new int[max+1];
		
		for(int i=1 ; i<max+1 ; i++) {
			if(!tasks.containsKey(i)) continue;
			
			ArrayList<Integer> arr = tasks.get(i);

			Collections.sort(arr, Collections.reverseOrder());

			while(!arr.isEmpty()) {
				if(completed[i] == 0) {
					completed[i] = arr.get(0);
				}
				else {
					int min = 1001;
					int idx = 0;
					
					for(int j=1 ; j<i ; j++) {
						if(min > completed[j]) {
							min = completed[j];
							idx = j;
						}
					}
					
					if(completed[idx] < arr.get(0))
						completed[idx] = arr.get(0);
				}
				arr.remove(0);
			} // while_arr
		} // for_i
		
		int sum = 0;
		for(int i=1 ; i<max+1 ; i++)
			sum +=completed[i];
		
		System.out.println(sum);
	}

}