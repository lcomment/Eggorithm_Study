import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_10815 {
    static Map<Integer, Boolean> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(value -> map.put(value, true));

        int M = Integer.parseInt(br.readLine());

        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(value -> {
                    if(map.containsKey(value)){
                        sb.append(1).append(" ");
                    } else {
                      sb.append(0).append(" ");
                    }
                });

        System.out.println(sb);
    }
}
