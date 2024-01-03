import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[][] data = new int[4][8];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        for(int i=0; i<4 ; i++){
            String tmp = br.readLine();
            for(int j=0; j<8; j++){
                data[i][j] = tmp.charAt(j) -'0';
            }
        }
        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int pick = Integer.parseInt(st.nextToken())-1;
            int flag = Integer.parseInt(st.nextToken());

            gear(pick, flag);
        }

        for(int i=0; i<4; i++){
            answer += Math.pow(2, i)*data[i][0];
        }

        System.out.println(answer);
    }

    private static void gear(int pick, int flag) {
        leftWheel(pick-1, -flag);
        rightWheel(pick+1, -flag);
        rotation(pick, flag);
    }

    private static void rotation(int pick, int flag) {
        if(flag == 1){
            int memory = data[pick][7];
            for(int i=7; i>0; i--){
                data[pick][i] = data[pick][i-1];
            }
            data[pick][0] = memory;
        }
        else{
            int memory = data[pick][0];
            for(int i=0; i<=6; i++){
                data[pick][i] = data[pick][i+1];
            }
            data[pick][7] = memory;
        }
    }

    private static void rightWheel(int pick, int flag) {
        if(pick > 3)    return;
        if(data[pick][6] == data[pick-1][2]){
            return;
        }
        rightWheel(pick+1, -flag);
        rotation(pick, flag);
    }

    private static void leftWheel(int pick, int flag) {
        if(pick < 0)    return;
        if(data[pick][2] == data[pick+1][6]){
            return;
        }
        leftWheel(pick-1, -flag);
        rotation(pick, flag);
    }
}
