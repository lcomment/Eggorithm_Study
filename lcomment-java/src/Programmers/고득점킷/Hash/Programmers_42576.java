package Programmers.고득점킷.Hash;

import java.util.HashMap;
import java.util.Map;

public class Programmers_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        Map<String, Integer> map = new HashMap<>();

        for(String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);
        for(String player : completion)
            map.put(player, map.get(player) -1);
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                return key;
            }
        }
        return answer;
    }
}