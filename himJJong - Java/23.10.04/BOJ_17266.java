import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BOJ_17266 {
    static int N;
    static int[] data;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        data = new int[M];
        String[] tmp = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            data[i] = Integer.parseInt(tmp[i]);
        }

        int left = 0;
        int right = N;
        int mid = 0;
        int result = 0;


        while(left <= right){
            mid = (left + right)/2;

            if(check(mid)){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int mid) {
        int memory = 0;
        for(int i=0; i<data.length; i++){
            int f = data[i] - mid;
            int e = data[i] + mid;

            if(f < 0)   f = 0;
            if(e > N)   {
                e = N;
            }

            if(memory < f)  return false;
            else{
                memory = e;
            }
        }
        if(memory < N)  return false;
        return true;
    }
}
