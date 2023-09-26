import java.util.*;

class programmes_짝지어제거하기{
    public int solution(String s){
        Stack<String> st = new Stack<>();
        String[] tmp = s.split("");
        int index = 0;
        st.add(tmp[index]);      //만약 s가 1개라면 오류

        if(s.length() == 1) return 0;
        index++;
        while(index != s.length()){
            if(!st.isEmpty() && st.peek().equals(tmp[index])){
                st.pop();
            }
            else{
                st.add(tmp[index]);
            }
            index++;
        }

        if(st.isEmpty()) {
            return 1;
        }
        return 0;
    }
}