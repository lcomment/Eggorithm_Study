package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Conference> asp = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++) {
			String[] input = br.readLine().split(" ");
			asp.add(new Conference(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		
		Collections.sort(asp, new Comparator<Conference>() {
			@Override
			public int compare(Conference o1, Conference o2) {
				int f_result = o1.f - o2.f;
				
				if(f_result == 0)
					return o1.s - o2.s;
				
				return f_result;
			}
		});
		
		int time = asp.get(0).f;
		int cnt = 1;
		for(int i=1 ; i<asp.size() ; i++) {
			if(asp.get(i).s >= time) {
				cnt++;
				time = asp.get(i).f;
			}
		}
		
		System.out.println(cnt);
	}

}

class Conference {
	int s;
	int f;
	Conference(int s, int f){
		this.s = s;
		this.f = f;
	}
}