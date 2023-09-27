import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11652 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long,Integer> map = new HashMap<>();
        List<Long> answer = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            long tmp = Long.parseLong(br.readLine());
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        long min = Long.MIN_VALUE;
        Iterator<Map.Entry<Long, Integer>> it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Long, Integer> entry = it.next();
            if(min < entry.getValue()){
                answer.clear();
                min = entry.getValue();
                answer.add(entry.getKey());
            }
            else if(min == entry.getValue()){
                answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}
