import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pro_파일명 {
    public static void main(String[] args) {
        String[] arr = {"abc123123"};
        System.out.println(Solution.solution(arr));
    }

    static class Solution {
        public static String[] solution(String[] files) {
            String[] answer = new String[files.length];
            String[][] result = new String[files.length][3];

            for(int i=0; i<files.length; i++){
                int start = -1;
                int end = -1;
                int size = 0;
                boolean flag = true;

                for(int j=0; j<files[i].length(); j++){
                    if(Character.isDigit(files[i].charAt(j))){
                        if(flag) {
                            flag = false;
                            start = j;
                        }
                        size++;
                    }
                    else{
                        if(!flag){
                            break;
                        }
                    }
                }
                end = start + size - 1;

                result[i][0] = files[i].substring(0,start);
                result[i][1] = files[i].substring(start, end+1);
                result[i][2] = files[i].substring(end+1);

                System.out.println(result[i][0]);
                System.out.println(result[i][1]);
                System.out.println(result[i][2]);
            }

            Arrays.sort(result, (o1, o2) -> {
                if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) > 0){
                    return 1;
                }
                else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) < 0){
                    return -1;
                }
                else{
                    if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])){
                        return 1;
                    }else if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });

            for(int i=0; i<files.length; i++){
                answer[i] = result[i][0] + result[i][1] + result[i][2];
                System.out.println(answer[i]);
            }
            return answer;
        }
    }
}
