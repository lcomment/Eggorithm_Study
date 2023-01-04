import java.io.*;
import java.util.*;

public class BOJ_13144 {
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        long answer = 0;
        int max = 0;

        int[] data = new int[num];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<data.length; i++){
            data[i] = Integer.parseInt(st.nextToken());
            max = Math.max(data[i], max);
        }
        check = new int[max+1];

        int start = 0;
        int end = 0;

        while(start != num) {
            while (end <= data.length-1 && check[data[end]] == 0) {
                check[data[end]]++;
                end++;
                answer++;
            }
            Arrays.fill(check, 0);
            start++;
            end = start;
        }
        System.out.println(answer);
    }
}