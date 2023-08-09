import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
    public static void main(String[] args)throws IOException {
        Stack<String> st = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split("");
        String memory = "";
        int answer = 0;
        for(int i=0; i<data.length;i++){
            if(data[i].equals("(")){
                st.add(data[i]);
                memory = "(";
            }
            else if(!st.isEmpty() && data[i].equals(")") && memory.equals("(")){
                st.pop();
                answer += st.size();
                memory = ")";
            }
            else if(data[i].equals(")") && memory.equals(")")){
                st.pop();
                answer++;
                memory = ")";
            }
        }

        System.out.println(answer);
    }
}
