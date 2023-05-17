import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class softeer_mapAuto {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double a = 1;
        double b = Math.pow(a+1,2);

        for(int i=1; i<=N; i++){
            a = Math.pow(Math.sqrt(a)*2,2);
            b = Math.pow(Math.sqrt(a)+1,2);
        }

        System.out.println((int)b);
    }
}
