import javax.lang.model.type.IntersectionType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21318 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] prefix = new int[N];
        prefix[0] = 0;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=1; i<N; i++){
            if(Integer.parseInt(tmp[i-1]) > Integer.parseInt(tmp[i])){
                prefix[i] = ++index;
            }
            prefix[i] = index;
        }
        int test = Integer.parseInt(br.readLine());

        for(int i=0; i<test; i++){
            String[] tmp1 = br.readLine().split(" ");
            sb.append(prefix[Integer.parseInt(tmp1[1])-1] - prefix[Integer.parseInt(tmp1[0])-1]).append("\n");
        }

        System.out.println(sb);
    }
}
