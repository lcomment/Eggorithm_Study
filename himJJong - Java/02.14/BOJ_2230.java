import java.io.*;
import java.util.*;

public class BOJ_2230 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] data = new int[NM[0]];

        for(int i=0; i<NM[0]; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;
        int m = 0;

        Arrays.sort(data);

        for(int i=0; i<NM[0]; i++){
            s = i;
            e = NM[0];

            while(s < e){
                m = (s+e)/2;
                if(data[m] - data[i] <NM[1]){
                    s = m+1;
                }
                else e = m;
            }
            if(e != NM[0] || s < 0){
                answer = Math.min(answer,data[e] - data[i]);
            }
            if(answer == NM[1]) break;
        }
        System.out.println(answer);
    }
}
