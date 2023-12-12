import java.util.*;

public class pro_3차압축 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("KAKAO"));
    }

    static class Solution {
        public static int[] solution(String msg) {
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 1; i < 27; i++) {
                char alpha = (char) (64 + i);
                map.put(String.valueOf(alpha), i);
            }

            for (int i = 0; i < msg.length(); i++) {
                String key = msg.charAt(i) + "";
                int index = i + 1;

                while (index <= msg.length()) {
                    if (index == msg.length()) {
                        list.add(map.get(msg.substring(i)));
                        i = index;
                        break;
                    }

                    String nextKey = msg.substring(i, index + 1);

                    if (map.containsKey(nextKey)) {
                        index++;
                    } else {
                        key = msg.substring(i, index);
                        list.add(map.get(key));
                        map.put(nextKey, map.size() + 1);
                        i = index - 1;
                        break;
                    }
                }
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
