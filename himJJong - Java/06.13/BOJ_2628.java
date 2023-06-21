import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2628 {
    static List<Integer> xlist = new ArrayList<>();
    static List<Integer> ylist = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int row = Integer.MIN_VALUE;
        int col = Integer.MIN_VALUE;

        int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 0)   xlist.add((Integer.parseInt(st.nextToken())));
            else ylist.add((Integer.parseInt(st.nextToken())));
        }

        Collections.sort(xlist);
        Collections.sort(ylist);

        int x = 0;
        for(int i=0; i<xlist.size(); i++){
            row = Math.max(row, xlist.get(i) - x);
            x = xlist.get(i);
        }

        row = Math.max(row, M - x);

        int y = 0;
        for(int i=0; i<ylist.size(); i++){
            col = Math.max(col, ylist.get(i) - y);
            y = ylist.get(i);
        }

        col = Math.max(col, N - y);

        System.out.println(row*col);
    }
}
