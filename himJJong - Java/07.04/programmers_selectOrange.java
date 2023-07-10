import java.util.*;

public class programmers_selectOrange {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        int k = 4;
        int[] tangerine = {1,1,1,1,2,2,2,3};

        for(int i=0; i<tangerine.length; i++){
            map.put(String.valueOf(tangerine[i]),map.getOrDefault(String.valueOf(tangerine[i]),0)+1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        int answer = 0;
        for(int i=keySet.size()-1; i>=0; i--){
            k -= map.get(keySet.get(i));
            answer++;
            if(k <= 0) break;
        }
        System.out.println(answer);
    }
}
