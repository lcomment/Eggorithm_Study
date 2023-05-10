import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16401 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int child = Integer.parseInt(st.nextToken());
        int eat = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<eat; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int left = 1;
        int right = list.get(list.size()-1);
        int answer = Integer.MIN_VALUE;

        while(left <= right){
            int cnt = 0;
            int mid = (left+right)/2;

            for(int i=0; i<eat; i++){
                cnt += list.get(i) / mid;
            }

            if(cnt >= child){
                if(answer < mid) answer = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        if(answer==Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
