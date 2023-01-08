package BOJ.DataStructure;

import java.io.*;
import java.util.*;

public class BOJ_20920 {
    static int N, M;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        initStatic(br.readLine().split(" "));
        map = new HashMap<>();

        for(int i=0 ; i<N ; i++) {
            String s = br.readLine();
            if(!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        // 엔트리로 List 생성
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 횟수 비교
                int result1 =  o2.getValue() - o1.getValue();

                if(result1 == 0) {
                    // 문자열 길이 비교
                    int result2 = o2.getKey().length() - o1.getKey().length();

                    if(result2 == 0) {
                        // 사전순 비교
                        return o1.getKey().compareTo(o2.getKey());
                    }

                    return result2;
                }

                return result1;
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
            if(entry.getKey().length() >= M) {
                bw.write(entry.getKey() + "\n");
            }
        }
        bw.flush();
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static void initStatic(String[] s) {
        N = sToI(s[0]);
        M = sToI(s[1]);
    }
}
