import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            String[] tmp = br.readLine().split("");
            Stack<String> s1 = new Stack<>();
            Stack<String> s2 = new Stack<>();

            for(int i=0; i<tmp.length; i++){
                if(tmp[i].equals("<")){
                    if(!s1.isEmpty()){
                        s2.push(s1.pop());
                    }
                }
                else if(tmp[i].equals(">")){
                    if(!s2.isEmpty()){
                        s1.push(s2.pop());
                    }
                }
                else if(tmp[i].equals("-")){
                    if(!s1.isEmpty()){
                        s1.pop();
                    }
                }
                else{
                    s1.push(tmp[i]);
                }
            }

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            while(!s2.isEmpty()){
                sb.append(s2.pop());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
