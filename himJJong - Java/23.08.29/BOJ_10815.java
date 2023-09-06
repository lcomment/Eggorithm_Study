import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] card = new int[N];
        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        int checkNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] check = new int[checkNum];
        for(int i=0; i<checkNum; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(checkNum != index){
            int left = 0;
            int right = N-1;
            boolean flag = false;
            while(left <= right){
                int mid = (left + right) / 2;

                if(card[mid] > check[index]){
                    right = mid-1;
                }
                else if(card[mid] < check[index]){
                    left = mid+1;
                }
                else {
                    sb.append("1").append(" ");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                sb.append("0").append(" ");
            }
            index++;
        }

        System.out.println(sb);
    }
}
