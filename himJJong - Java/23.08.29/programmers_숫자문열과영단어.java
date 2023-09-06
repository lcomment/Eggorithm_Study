import java.util.*;

public class programmers_숫자문열과영단어 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String s ="";
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        String answer = "";
        String check = "";
        char[] tmp = s.toCharArray();
        for(int i=0;i<tmp.length; i++){
            if(map.containsKey(check)){
                answer += map.get(check);
                check = "";
            }
            if(Character.getNumericValue(tmp[i]) < 10 && check.length() == 0){
                answer += tmp[i];
            }
            else if(Character.getNumericValue(tmp[i]) >= 10){
                check += tmp[i];
            }
            else if(Character.getNumericValue(tmp[i]) < 10 && check.length() != 0){
                answer += map.get(check);
                check = "";
                answer += String.valueOf(tmp[i]);
            }
        }
        if(check.length() !=0){
            check = map.get(check);
            answer += check;
            System.out.println(Integer.parseInt(answer));
        }
        System.out.println(Integer.parseInt(answer));
    }
}
