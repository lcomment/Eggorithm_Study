import java.util.HashMap;
import java.util.Map;

public class programmers_discountFestival {
    static Map<String, Integer> map;
    static Map<String, Integer> mapData;
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer = 0;

        map = new HashMap<>();
        mapData = new HashMap<>();

        for(int i=0; i<want.length; i++){
            map.put(want[i],number[i]);
        }

        int index = 0;
        for(int i=0; i<discount.length; i++){
            if(i <= 9){
                mapData.put(discount[i],mapData.getOrDefault(discount[i],0)+1);
            }
            else{
                mapData.put(discount[index],mapData.get(discount[index])-1);
                if(mapData.get(discount[index]) == 0)   mapData.remove(discount[index]);
                mapData.put(discount[i],mapData.getOrDefault(discount[i],0)+1);
                index++;
            }

            if(i >= 9 && check(want, number)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(String[] want, int[] number) {
            for(int i=0; i<map.size() ;i++){
                if(mapData.containsKey(want[i]) && number[i] <= mapData.get(want[i])){
                    continue;
                }
                else    return false;
            }
            return true;
    }
}
