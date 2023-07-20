import java.util.Stack;

public class programmers_correctBracket {
    public static void main(String[] args) {
        String s = "()()";
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')  st.push('(');
            else if(s.charAt(i) == ')'){
                if(st.isEmpty()) System.out.println("false");
                st.pop();
            }
        }
        if(!st.isEmpty()) System.out.println("false");
        System.out.println("true");
    }
}
