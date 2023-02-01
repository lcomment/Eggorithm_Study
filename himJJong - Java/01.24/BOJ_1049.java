import java.util.*;
import java.io.*;

public class BOJ_1049 {
    static int[] user = new int[2];
    static int[][] data;
    static int answer = Integer.MAX_VALUE;
    static int[] cal = new int[2];
    static int[] minData = new int[2];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        user[0] = Integer.parseInt(st.nextToken());
        user[1] = Integer.parseInt(st.nextToken());
        data = new int[user[1]][2];

        int minPackage = Integer.MAX_VALUE;
        int minPer = Integer.MAX_VALUE;

        for(int i=0; i<user[1]; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            minPackage = Math.min(minPackage,data[i][0]);
            minPer = Math.min(minPer,data[i][1]);

        }

        cal[0] = user[0]/6;
        cal[1] = user[0]%6;

        if(user[0] < 6){
            answer = Math.min(minPackage,minPer*user[0]);
        }
        else{
            answer = Math.min((cal[0]+1)*minPackage,cal[0]*minPackage+cal[1]*minPer);
            answer = Math.min(user[0]*minPer, answer);
        }

        System.out.println(answer);
    }
}
