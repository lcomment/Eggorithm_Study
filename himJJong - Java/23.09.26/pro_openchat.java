import java.util.*;

class pro_openchat {
    static List<String> resultList = new ArrayList<>();
    static Map<String, String> map = new HashMap<>();
    public String[] solution(String[] record) throws ClassCastException{
        for(int i=0; i<record.length; i++){
            String[] tmp = record[i].split(" ");
            if(tmp.length > 2){
                map.put(tmp[1], tmp[2]);
            }
        }

        for(int i=0; i<record.length ; i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter")){
                resultList.add(map.get(tmp[1])+"님이 들어왔습니다.");
            }
            else if(tmp[0].equals("Leave")){
                resultList.add(map.get(tmp[1])+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[resultList.size()];
        resultList.toArray(answer);

        return answer;
    }
}