package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BOJ_1700 {
	static App[] PowerBar;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		PowerBar = new App[N];
		
		Integer[] seq = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		Set<Integer> tool = new HashSet<>(Arrays.asList(seq));
		App[] kind = new App[101];
		
		for(int i : tool) 
			kind[i] = new App(i);
		
		int count = 0;
		
		int full = 0;
		for(int i=0 ; i<seq.length ; i++) {
			if(!kind[seq[i]].used) {
				// 멀티탭에 빈 자리가 있는 경우 
				if(full != N) {
					PowerBar[full] = kind[seq[i]];
					kind[seq[i]].used = true;
					full++;
				}
				else {
					int idx = i+1;
					int[] cnt = new int[N];
					for(int j=idx ; j<idx+PowerBar.length ; j++) {
						try {
							for(int k=0 ; k<PowerBar.length ; k++) {
								if(seq[j] == PowerBar[k].kind) {
									cnt[k] += N-(j-idx);
									break;
								}
							}
						}catch(IndexOutOfBoundsException e) {
							break;
						}
					}  // for_j
					int off = checkPB(cnt, seq, idx+PowerBar.length);
					PowerBar[off].used = false;
					PowerBar[off] = kind[seq[i]];
					kind[seq[i]].used = true;
					count++;
				}
			}
		} // for_i
		System.out.println(count);
	}
	
	static int checkPB(int[] arr, Integer[] seq, int index) {
		int min = Integer.MAX_VALUE;
		int idx = -1;
		int zero = 0;
		ArrayList<Integer> arrList = new ArrayList<>();
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] < min) {
				min = arr[i];
				idx = i;
			}
			if(arr[i] == 0) {
				zero++;
				arrList.add(i);
			}
		}
		if(zero==0)
			return idx;
		else {
			while(arrList.size() != 1) {
				try {
					for(int i=0 ; i<arrList.size() ; i++) {
						if(seq[index] == PowerBar[arrList.get(i)].kind) {
							arrList.remove(i);
							break;
						}
					}
				} catch(IndexOutOfBoundsException e) {
					break;
				}
				index++;
			}
			return arrList.get(0);
		}
	}
}
// 사용하고 있다 
// 사용하고 있지 않고 자리가 있다 
// 사용하고 있지 않고 자리가 없다 
class App {
	boolean used;
	int kind;
	App(int kind){
		this.used = false;
		this.kind = kind;
	}
}