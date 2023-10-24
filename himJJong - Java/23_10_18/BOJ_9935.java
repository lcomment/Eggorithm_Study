import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();

        String origin = br.readLine();
        String bomb = br.readLine();

        for(int i=0; i<origin.length(); i++){
            s.push(origin.charAt(i));
            if(s.size() >= bomb.length()){
                boolean flag = true;

                for(int j=0; j<bomb.length(); j++){
                    if(s.get(s.size() - bomb.length() + j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int k=0; k<bomb.length() ;k++){
                        s.pop();
                    }
                }
            }
        }

        if(s.isEmpty()){
            System.out.println("FRULA");
            System.exit(0);
        }

        Stack<Character> s2 = new Stack<>();
        while(!s.isEmpty()){
            s2.add(s.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!s2.isEmpty()){
            sb.append(s2.pop());
        }

        System.out.println(sb);
    }
}
