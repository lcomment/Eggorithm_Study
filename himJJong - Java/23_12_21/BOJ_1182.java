import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    static int answer = 0;
    static String[] NM;
    static String[] data;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NM = br.readLine().split(" ");
        data = br.readLine().split(" ");

        for(int i=1; i<=data.length; i++){
            btk(i,0, 0, 0);
        }
        System.out.println(answer);
    }

    private static void btk(int N, int sum, int at, int cur) {
        if(N == cur) {
            if (sum == Integer.parseInt(NM[1])) {
                answer++;
            }
            return;
        }

        for(int i=at; i<Integer.parseInt(NM[0]); i++){
            btk(N, sum + Integer.parseInt(data[i]), i+1, cur+1);
        }
    }
}
