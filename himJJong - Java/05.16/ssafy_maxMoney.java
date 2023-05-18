import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ssafy_maxMoney {
    static String[] tmp;
    static int max;
    static int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <=T ; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            tmp = st.nextToken().split("");
            count = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            if(count > tmp.length)  count = tmp.length;

            backTracking(0,0);

            System.out.println("#"+test_case+" "+max);
        }
    }

    private static void backTracking(int at,int depth) {
        if(depth == count){
            String cur = "";
            for(int i=0; i<tmp.length; i++){
                cur += tmp[i];
            }
            max = Math.max(max,Integer.parseInt(cur));
            return;
        }

        for(int i=at; i<tmp.length; i++){
            for(int j=i+1; j<tmp.length; j++){
                String tmp1 = "";
                tmp1 = tmp[i];
                tmp[i] = tmp[j];
                tmp[j] = tmp1;

                backTracking(at,depth+1);

                tmp1 = tmp[i];
                tmp[i] = tmp[j];
                tmp[j] = tmp1;
            }
        }
    }
}
