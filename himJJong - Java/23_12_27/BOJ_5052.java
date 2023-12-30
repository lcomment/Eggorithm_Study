import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class BOJ_5052 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean flag = true;

            String[] data = new String[N];
            for (int j = 0; j < N; j++) {
                data[j] = br.readLine();
            }

            Arrays.sort(data);

            for(int j=0; j<N-1; j++){
                if(data[j].length() <= data[j+1].length() && data[j].equals(data[j+1].substring(0,data[j].length()))){
                    flag = false;
                    System.out.println("NO");
                    break;
                }
            }

            if(flag){
                System.out.println("YES");
            }
        }
    }
}
