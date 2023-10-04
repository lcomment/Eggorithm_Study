import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
    static int[] classRoom;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        classRoom = new int[n];

        st = new StringTokenizer(br.readLine());

        int left = Integer.MIN_VALUE;
        int right = 0;

        for(int i=0; i<n; i++){
            classRoom[i] = Integer.parseInt(st.nextToken());
            right += classRoom[i];
            left = Math.max(classRoom[i], left);
        }

        while(left <= right){
            int mid = (right + left) / 2;
            int result = check(mid);

            if(result > m){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    private static int check(int mid) {
        int sum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(sum +classRoom[i]<= mid){
                sum += classRoom[i];
            }
            else{
                sum = classRoom[i];
                count++;
            }
        }

        if(sum != 0)    count++;
        return count;
    }
}