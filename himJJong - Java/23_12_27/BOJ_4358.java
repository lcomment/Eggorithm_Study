import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BOJ_4358 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>();
        int count = 0;
        String s;
        while((s = br.readLine()) != null){
            map.put(s, map.getOrDefault(s, 0)+1);
            count++;
        }

        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();

        while(entries.hasNext()){
            Map.Entry<String, Integer> entry = entries.next();
            sb.append(entry.getKey()+" ").append(String.format("%.4f",(double)entry.getValue() * 100 / (double) count)).append("\n");
        }
        System.out.println(sb);
    }
}
/*
Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
while(entries.hasNext()){
    Map.Entry<String, Integer> entry = entries.next();
    entry.getValue();
}

String.format("%.3f", (double) 100 * 100 / (double) 3);
 */
