import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564 {
    static int[][] user = new int[1][2];
    static int answer = 0;
    static int N;
    static int M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(br.readLine());

        int[][] data = new int[count][2];

        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] =Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        user[0][0] = Integer.parseInt(st.nextToken());
        user[0][1] = Integer.parseInt(st.nextToken());

        for(int i=0; i<count; i++){
            if(user[0][0] == data[i][0]){
                answer += Math.abs(user[0][1] - data[i][1]);
                continue;
            }
            if(user[0][0] == 1){
                if(data[i][0] == 2){
                    answer += Math.min(user[0][1] + data[i][1], (N-user[0][1]) + (N-data[i][1])) + M;
                }
                else if(data[i][0] == 3){
                    answer += data[i][1] + user[0][1];
                }
                else if(data[i][0] == 4){
                    answer += data[i][1] + (N-user[0][1]);
                }
            }
            else if(user[0][0] == 2){
                if(data[i][0] == 1){
                    answer += Math.min(user[0][1] + data[i][1], (N-user[0][1]) + (N-data[i][1])) + M;
                }
                else if(data[i][0] == 3){
                    answer += (M-data[i][1]) + user[0][1];
                }
                else if(data[i][0] == 4){
                    answer += (M-data[i][1]) + (N-user[0][1]);
                }
            }
            else if(user[0][0] == 3){
                if(data[i][0] == 2){
                    answer += data[i][1] + (M-user[0][1]);
                }
                else if(data[i][0] == 1){
                    answer += (user[0][1]) + data[i][1];
                }
                else if(data[i][0] == 4){
                    answer += Math.min(user[0][1] + data[i][1], (M-user[0][1]) + (M-data[i][1])) + N;
                }
            }
            else if(user[0][0] == 4){
                if(data[i][0] == 2){
                    answer += (N - data[i][1]) + (M - user[0][1]);
                }
                else if(data[i][0] == 3){
                    answer += Math.min(user[0][1] + data[i][1], (M-user[0][1]) + (M-data[i][1])) + N;
                }
                else if(data[i][0] == 1){
                    answer += user[0][1] + (N-data[0][1]);
                }
            }
        }
        System.out.println(answer);
    }
}
