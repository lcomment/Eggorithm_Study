import java.util.*;

class programmers_menuRenew {
    static Map<String, Integer> treeMap = new TreeMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        for(int i=0; i<orders.length; i++){
            String[] tmp = orders[i].split("");
            Arrays.sort(tmp);
            orders[i] = "";
            for(int j=0; j<tmp.length; j++){
                orders[i] += tmp[j];
            }
        }


        for(int i=0; i< course.length; i++){
            for(int j=0; j< orders.length; j++){
                backTracking(course[i], orders[j], 0, 0, "");
            }
        }

        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i=0; i<course.length; i++){
            int size = course[i];
            int memory = Integer.MIN_VALUE;
            for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
                if(entry.getKey().length() == size && (entry.getValue() == memory) && entry.getValue() > 1){
                    list.add(entry.getKey());
                }
                else if(entry.getKey().length() == size && (entry.getValue() > memory) && entry.getValue() > 1){
                    list.clear();
                    memory = entry.getValue();
                    list.add(entry.getKey());
                }
            }
            for(int j=0; j<list.size(); j++){
                if(!map.containsKey(list.get(j))){
                    map.put(list.get(j),0);
                    System.out.println(list.get(j));
                }
            }
        }

        String[] result = new String[map.size()];
        int index = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(index == map.size()) break;
            result[index] = entry.getKey();
            index++;
        }

        Arrays.sort(result);
        return result;
    }

    private static void backTracking(int limit, String tmp, int depth, int at, String make) {
        if(make.length() == limit){
            if(!treeMap.containsKey(make)){
                treeMap.put(make,1);
            }
            else treeMap.put(make, treeMap.get(make)+1);
            return;
        }

        for(int i=at; i<tmp.length(); i++){
            make += tmp.charAt(i);
            backTracking(limit, tmp, depth+1, i+1, make);
            make = make.substring(0, make.length()-1);
        }
    }
}