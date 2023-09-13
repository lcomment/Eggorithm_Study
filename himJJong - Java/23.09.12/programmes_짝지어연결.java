import java.util.*;

public class programmes_짝지어연결{
    public static void main(String[] args) {
        String s = "124";
        Stack<String> st = new Stack<>();
        String[] tmp = s.split("");
        int index = 0;
        st.add(tmp[index]);      //만약 s가 1개라면 오류

        if(s.length() == 1) System.out.println(0);
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
            System.out.println(1);
        }
        System.out.println(0);
    }
}