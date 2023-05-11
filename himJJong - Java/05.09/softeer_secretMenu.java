import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer_secretMenu {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int secretLength = Integer.parseInt(st.nextToken());
        int inputLength = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        if(secretLength > inputLength) {
            System.out.println("normal");
            System.exit(0);
        }

        String tmp = br.readLine().replaceAll(" ","");
        String tmp1 = br.readLine().replaceAll(" ","");

        if(tmp1.contains(tmp)) System.out.println("secret");
        else System.out.println("normal");

    }
}
