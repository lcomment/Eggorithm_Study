import java.util.*;

class programmers_괄호회전 {
    public int solution(String sa) {
        int size = sa.length();
        int answer = 0;
        StringBuffer sb = new StringBuffer(sa);
        Stack<String> s = new Stack<>();
        Stack<String> s2 = new Stack<>();

        if(sa.length() % 2 == 1)    return 0;
        while(size -- >0){
            String[] tmp = sb.toString().split("");
            for(int i=0; i<tmp.length; i++){
                s.add(tmp[i]);
            }
            while(!s.isEmpty()){
                String cur = s.pop();
                if(cur.equals("}") || cur.equals("]") || cur.equals(")")){
                    s2.add(cur);
                }
                else if(cur.equals("(") && !s2.isEmpty() && (s2.peek().equals(")"))){
                    s2.pop();
                }
                else if(cur.equals("{") && !s2.isEmpty() &&(s2.peek().equals("}"))){
                    s2.pop();
                }
                else if(cur.equals("[") && !s2.isEmpty() &&(s2.peek().equals("]"))){
                    s2.pop();
                }
                else{
                    break;
                }
            }

            if(s.size() == 0 && s2.size() == 0){
                answer++;
            }

            String last = sb.substring(sa.length()-1, sa.length());
            sb.delete(sa.length()-1, sa.length());
            sb.insert(0,last);

            s.clear();
            s2.clear();
        }
        return answer;
    }
}