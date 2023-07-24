import java.util.*;

public class programmers_makeBigNumber {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        String[] tmp = number.split("");


        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });

        for(int i=0; i<tmp.length; i++){
            map1.put(tmp[i],map1.getOrDefault(tmp[i],0)+1);
        }

        map.putAll(map1);

        System.out.println(1);

        // 4177252841
        // 1:2, 2:2, 4:2, 5:1, 7:2, 8:1
        // 4
    }
}
