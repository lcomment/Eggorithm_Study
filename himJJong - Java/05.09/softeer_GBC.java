import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer_GBC {
    static int max = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] rule = new int[N][2];
        int[][] check = new int[M][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            rule[i][0] = Integer.parseInt(st.nextToken());
            rule[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            check[i][0] = Integer.parseInt(st.nextToken());
            check[i][1] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        for(int i=0; i<N; i++){
            for(int j = index; j<M; j++){
                if(rule[i][0] < check[j][0]){
                    check[j][0] -= rule[i][0];
                    max = Math.max(max, check[index][1] - rule[i][1]);
                    break;
                }
                else if(rule[i][0] > check[j][0]){
                    rule[i][0] -= check[j][0];
                    max = Math.max(max, check[index][1] - rule[i][1]);
                    index++;
                }
                else{
                    max = Math.max(max, check[index][1] - rule[i][1]);
                    index++;
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
