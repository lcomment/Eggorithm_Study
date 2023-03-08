import java.io.*;
import java.util.*;

public class BOJ_2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max=0;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //접시수
        int d = Integer.parseInt(st.nextToken()); //초밥 수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        int [] sushi = new int[N];
        for(int i=0;i<N;i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int [] check = new int[d+1];
        int count=0;

        for(int i=0;i<k;i++) {
            if(check[sushi[i]]==0) count++;
            check[sushi[i]]++;
        }

        max = count;
        int start=1, end=k;
        while(start!=N) {

            if(check[sushi[start-1]]==1) count--;
            check[sushi[start-1]]--;

            if(check[sushi[end]]==0) count++;
            check[sushi[end]]++;

            if(check[c]==0) max = Math.max(max, count+1);
            else max = Math.max(max, count);

            start++; end++;
            if(end==N) end=0;
        }
        System.out.println(max);
    }
}
