import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int fisrt = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int size = 0;

        for(int i=0; i<fisrt+second; i++){
            String tmp = br.readLine();
            if(!map.containsKey(tmp)) map.put(tmp,1);
            else {
                map.put(tmp,map.get(tmp)+1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) continue;
            else {
                sb.append(entry.getKey()).append("\n");
                size++;
            }
        }

        System.out.println(size);
        System.out.print(sb);
    }
}
