import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_jjakggong {
    static int[] weights = {100, 180, 360, 100, 270};
    public static void main(String[] args) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);

        for(int i =0; i<weights.length; i++) {
            double a = weights[i]*1.0;
            double b = (weights[i]*2.0)/3.0;
            double c = (weights[i]*1.0)/2.0;
            double d = (weights[i]*3.0)/4.0;

            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);

            map.put((weights[i]*1.0), map.getOrDefault((weights[i]*1.0), 0)+1);
        }
        System.out.println(answer);
    }
}
