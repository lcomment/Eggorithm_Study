import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            int hole = Integer.parseInt(s) * 10000000;
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                System.out.println("danger");
                continue;
            }
            int[] data = new int[N];

            for(int i=0; i<N; i++){
                data[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(data);

            int left = 0;
            int right = N-1;
            boolean flag = false;

            while(left < right){
                if(data[left] + data[right] == hole){
                    flag = true;
                    break;
                }
                if(data[left] + data[right] > hole){
                    right--;
                }
                else if(data[left] + data[right] < hole){
                    left++;
                }
            }

            if(flag){
                System.out.println("yes " + data[left] + " " + data[right]);
            }
            else{
                System.out.println("danger");
            }
        }
    }
}
/*
1
4
9999998
1
2
9999999
1
1
1
20
2
100000000
100000000
 */
