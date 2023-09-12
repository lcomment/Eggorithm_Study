import java.util.*;

class programmers_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<words.length; i++){
            if(i==0){
                hs.add(words[i]);
                continue;
            }
            if(!hs.contains(words[i])){
                if(i >= 1){
                    String[] tmp = words[i-1].split("");
                    String[] tmp1 = words[i].split("");

                    if(tmp[tmp.length-1].equals(tmp1[0])){
                        hs.add(words[i]);
                    }
                    else {
                        answer[0] = (i%n)+1;
                        answer[1] = (i/n)+1;
                        return answer;
                    }
                }
            }
            else{
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                return answer;
            }
        }
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}