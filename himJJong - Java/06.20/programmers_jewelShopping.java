import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class programmers_jewelShopping {
    static String[] gems = {"A","B","B","B","B","B","B","C","B","A"};
    public static void main(String[] args) {
        int kind = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];
        int length = Integer.MAX_VALUE;
        int start = 0;

        Map<String, Integer> map = new HashMap<>();

        for(int end = 0; end< gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end],0)+1);

            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }

            if(map.size() == kind && length > (end - start)){
                length = end - start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }

        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
