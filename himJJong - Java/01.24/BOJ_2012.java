import java.util.*;
import java.io.*;

public class BOJ_2012 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;
        int count = Integer.parseInt(br.readLine());
        int[] data = new int[count];
        for(int i=0; i<count ;i++){
            data[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(data);

        for(int i=0; i<count;i++){
            answer += Math.abs((i+1)-data[i]);
        }
        System.out.println(answer);
    }
}