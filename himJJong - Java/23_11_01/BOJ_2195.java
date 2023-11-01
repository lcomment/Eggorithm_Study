import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2195{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String[] P = br.readLine().split("");

        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(P[0]);
        for(int i=1; i<P.length; i++){
            if(S.contains(sb.toString())){
                sb.append(P[i]);
            }
            else{
                sb.delete(0,sb.length()-1);
                sb.append(P[i]);
                count++;
            }
        }
        if(S.contains(sb.toString())){
            count++;
        }
        else{
            count += 2;
        }
        System.out.println(count);
    }
}