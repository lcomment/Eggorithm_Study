import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String[] tmp = br.readLine().split("");
            if (tmp.length == 1 && tmp[0].equals(".")) break;

            System.out.println(check(tmp));
        }
    }

    private static String check(String[] tmp) {
        Stack<String> s = new Stack<>();
        for(int i=0; i< tmp.length; i++){
            if(tmp[i].equals("(") || tmp[i].equals("[")){
                s.add(tmp[i]);
            }

            else if(tmp[i].equals(")")){
                if(!s.isEmpty() && s.peek().equals("(")){
                    s.pop();
                }
                else return "no";
            }

            else if(tmp[i].equals("]")){
                if(!s.isEmpty() && s.peek().equals("[")){
                    s.pop();
                }
                else return "no";
            }
        }
        if(s.isEmpty()){
            return "yes";
        }
        return "no";
    }
}
