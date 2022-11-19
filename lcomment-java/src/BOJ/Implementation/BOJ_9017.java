package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_9017 {
	static int T;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			// key: 팀, value: 입력에 따른 등수 리스트 
			Map<Integer, ArrayList<Integer>> map = new HashMap<>();
			
			for(int i=0 ; i<N ; i++) {
				int team = seq[i];
				if(!map.containsKey(team)) map.put(team, new ArrayList<>());
				
				map.get(team).add(i+1);
			}
			
			Set<Integer> passTeam = new HashSet<>();;
			
			// 6명 아닌 팀 없애기 
			for(int key : map.keySet()) {
				if(map.get(key).size() == 6)  passTeam.add(key);	
			}
			
			
			int[] fifth = new int[201];  // 5번째의 등수만 저장할 테이블 
			int min = Integer.MAX_VALUE;   // 최소 총합점수  
			int champion = 1;   // 우승팀 번호 
			
			for(int team : passTeam) {
				int[] teamScore = new int[6];   // team의 등수 저장 
				
                int totalScore = 0;
                int idx = 0;
                int rank = 1;
                for (int i = 0; i < seq.length; i++) {
                    if(seq[i] == team)  teamScore[idx++] = rank;
                    
                    if(passTeam.contains(seq[i])) rank++;
                }
                
                // 5번째 저장 
                fifth[team] = teamScore[4];
                
                // 1~4번까지의 점수 합 구하기 
                for(int i=0 ; i<4 ; i++) totalScore += teamScore[i];
                

                // 점수를 비교
                if (min > totalScore) {
                    min = totalScore;
                    champion = team;
                }

                // 5번째 팀원 점수 비교
                else if (min == totalScore) {
                	if(fifth[team ]< fifth[champion]) {
                		champion = team;
                	}
                }
			}
			
			System.out.println(champion);
		}
		
	}

}
