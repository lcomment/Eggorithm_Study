import java.util.*;

class pro_kakao2 {
    static HashMap<String,Integer> map = new HashMap<String,Integer>();

    public static void main(String[] args) {
        String[] survey = {"AN","CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};
        String answer = "";
        String[] data = {"R","T","C","F","J","M","A","N"};

        for(int i=0; i<data.length; i++){
            map.put(data[i],0);
        }

        for(int i=0; i<survey.length; i++){
            if(choices[i] == 4) continue;

            String[] tmp = survey[i].split("");
            if(choices[i] == 1){
                map.put(tmp[0],map.get(tmp[0])+3);
            }
            else if(choices[i] == 2){
                map.put(tmp[0],map.get(tmp[0])+2);
            }
            else if(choices[i] == 3){
                map.put(tmp[0],map.get(tmp[0])+1);
            }
            else if(choices[i] == 5){
                map.put(tmp[1],map.get(tmp[1])+1);
            }
            else if(choices[i] == 6){
                map.put(tmp[1],map.get(tmp[1])+2);
            }
            else if(choices[i] == 7){
                map.put(tmp[1],map.get(tmp[1])+3);
            }
        }

        if(map.get("R") > map.get("T")){
            answer += "R";
        }
        else if(map.get("R") < map.get("T")){
            answer += "T";
        }
        else{
            answer += "R";
        }

        if(map.get("C") > map.get("F")){
            answer += "C";
        }
        else if(map.get("C") < map.get("F")){
            answer += "F";
        }
        else{
            answer += "C";
        }
        if(map.get("J") > map.get("M")){
            answer += "J";
        }
        else if(map.get("J") < map.get("M")){
            answer += "M";
        }
        else{
            answer += "J";
        }
        if(map.get("A") > map.get("N")){
            answer += "A";
        }
        else if(map.get("A") < map.get("N")){
            answer += "N";
        }
        else{
            answer += "A";
        }

        System.out.println(answer);
    }
}