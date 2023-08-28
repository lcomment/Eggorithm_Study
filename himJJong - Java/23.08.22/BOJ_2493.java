import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<int []> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(st.nextToken());

            while(!s.isEmpty()){
                if(num <= s.peek()[1]){
                    sb.append(s.peek()[0] +" ");
                    break;
                }
                s.pop();
            }
            if(s.isEmpty()){
                sb.append("0 ");
            }
            s.add(new int[] {i,num});
        }
        System.out.println(sb);
    }
}