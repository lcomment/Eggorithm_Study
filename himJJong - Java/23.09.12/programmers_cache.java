import java.util.*;

class programmers_cache {
    public int solution(int cacheSize, String[] cities) {
        List<String> list = new ArrayList<>();
        int answer = 0;
        if(cacheSize == 0){
            return 5*cities.length;
        }
        for(int i=0; i<cities.length; i++){
            boolean flag = false;
            for(int j=0; j<list.size(); j++){   //캐시 체크
                if(list.get(j).equals(cities[i].toLowerCase())){
                    answer++;
                    String tmp = list.remove(j);
                    list.add(tmp);
                    flag = true;
                    break;
                }
            }
            if(flag)    continue;
            if(list.size() < cacheSize){
                list.add(cities[i].toLowerCase());
                answer += 5;
                continue;
            }
            list.remove(0);
            list.add(cities[i].toLowerCase());
            answer+=5;
        }
        return answer;
    }
}