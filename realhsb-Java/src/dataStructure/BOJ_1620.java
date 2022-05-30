package dataStructure;

// BOJ - 1620번 나는야 포켓몬 마스터 이다솜 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

// stringbuilder 대신 bufferedwriter로 입력 받은 것도 했는데 sb가 약간 더 빠르고 메모리를 약간 더 잡아먹음
// ㅋㅋㅋㅋㅋㅋ 

public class BOJ_1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		// N : 포켓몬 마리 수, M : 찾을 포켓몬 수 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> hashMap = new HashMap<>();
		String[] pokeArr = new String[N+1];
		
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			hashMap.put(s, i);
			pokeArr[i] = s;
		}
		
		for(int i = 1; i <= M; i++) {
			String str = br.readLine();
			if(!isNumeric(str))		// 포켓몬 이름일 때,
				sb.append(hashMap.get(str));
			else {					// 숫자일 때,
				// 배열 인덱스로 바로 접근하는 것이 빠름
				sb.append(pokeArr[Integer.parseInt(str)]);
			}
			
			if(i != M) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	// 입력받은 string이 int로 변환 가능한지 확인하는 함수 
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
}
