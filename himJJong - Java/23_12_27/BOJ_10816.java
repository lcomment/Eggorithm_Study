import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_10816 {
    public static void main(String[] args)throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] m = br.readLine().split(" ");

        for(int i=0; i<m.length; i++){
            map.put(m[i], map.getOrDefault(m[i],0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<data.length; i++){
            if(map.containsKey(data[i])){
                sb.append(map.get(data[i]) + " ");
            }
            else{
                sb.append("0" + " ");
            }
        }
        System.out.println(sb);
    }
}