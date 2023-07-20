import java.util.*;

public class programmers_cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int total = 0;
        List<String> list = new ArrayList<>();

        if(cacheSize == 0) System.out.println(cities.length * 5);

        for(int i=0; i<cities.length; i++){
            if(!list.contains(cities[i].toLowerCase()) && list.size() == cacheSize)    {
                list.remove(0);
                total +=5;
                list.add(cities[i].toLowerCase());
            }
            else if(!list.contains(cities[i].toLowerCase())){
                total +=5;
                list.add(cities[i].toLowerCase());
            }
            else {
                int memory = 0;
                for(int j=0; j<list.size();j++){
                    if(list.get(j).equals(cities[i].toLowerCase())){
                        memory = j;
                        break;
                    }
                }
                list.remove(memory);
                list.add(cities[i].toLowerCase());
                total += 1;
            }
        }
        System.out.println(total);
    }
}
