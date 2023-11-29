import java.util.*;

class pro_clothes {
    public int s (String[][] clothes) {
        int answer = 1;
        Map<String, Integer> total = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String clothingType = clothes[i][1];
            if (total.containsKey(clothingType)) {
                total.put(clothingType, total.get(clothingType) + 1);
            } else {
                total.put(clothingType, 1);
            }
        }

        for (int count : total.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
