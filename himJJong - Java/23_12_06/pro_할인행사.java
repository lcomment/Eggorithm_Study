import java.util.*;

class pro_할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> s = new HashSet<>();
        int num = 0;
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
            num += number[i];
        }

        for(int i=0; i <= discount.length - num; i++){
            HashMap<String, Integer> check = new HashMap<>();
            boolean flag = true;
            for(int j=i; j<num+i; j++){
                check.put(discount[j], check.getOrDefault(discount[j],0) + 1);
            }

            for(int j=0; j<want.length; j++){
                if(check.get(want[j]) == map.get(want[j])){
                    continue;
                }
                else    {
                    flag = false;
                    break;
                }
            }
            if(flag)    answer++;
        }

        return answer;
    }
}