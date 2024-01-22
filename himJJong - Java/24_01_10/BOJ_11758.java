import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11758 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] data = new int[3][2];

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            data[i][0] = a;
            data[i][1] = b;
        }

        int check = ((data[1][0] - data[0][0]) * (data[2][1] - data[0][1])) - ((data[2][0] - data[0][0]) * (data[1][1] - data[0][1]));

        if(check < 0){
            System.out.println(-1);
        }
        else if(check == 0){
            System.out.println(0);
        }
        else {
            System.out.println(1);
        }
    }
}
