import java.io.*;
import java.util.*;

public class codeTree_Stack {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        String[] tmp = br.readLine().split(" ");

        for(int i=tmp.length-1; i>=0; i--){
            s1.push(Integer.parseInt(tmp[i]));
        }

        String[] tmp1 = br.readLine().split(" ");

        for(int i=tmp1.length-1; i>=0; i--){
            s2.push(Integer.parseInt(tmp1[i]));
        }

        while(true){
            if(s1.isEmpty() || s2.isEmpty())  break;
            if(s2.peek() == s1.peek()){
                s2.pop();
                s1.pop();
            }
            else{
                s1.pop();
            }
        }

        if(s2.isEmpty()){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

    }
}