package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1744 {
	static int N, result;
	static ArrayList<Integer> minusList = new ArrayList<>();
	static ArrayList<Integer> plusList = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input > 0)
				plusList.add(input);
			else
				minusList.add(input);
		}
		
		if(plusList.size() == 1) {
			result += plusList.get(0);
		} else if(plusList.size() != 0) {
			Collections.sort(plusList, Collections.reverseOrder());
		
			for(int i=0 ; i<plusList.size() ; i++) {
				if(i != plusList.size()-1) {
					if(plusList.get(i+1) != 1) {
						result += plusList.get(i) * plusList.get(i+1);
						i++;
					} else {
						result += plusList.get(i);
					}
					continue;
				}
				if(plusList.get(i) == 1)
					result += plusList.get(i);
				else if(i == plusList.size()-1)
					result += plusList.get(i);
			}
//			System.out.println(result);
		}
		
		if(minusList.size() == 1) {
			result += minusList.get(0);
		} else {
			Collections.sort(minusList);
			
			for(int i=0 ; i<minusList.size()-1 ; i+=2) {
				result += minusList.get(i) * minusList.get(i+1);
			}
			
			if(minusList.size()%2 == 1)
				result += minusList.get(minusList.size()-1);
//			System.out.println(result);
		}
		
		System.out.println(result);
	}

}
