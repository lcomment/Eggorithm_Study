import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_1920 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        String[] m = br.readLine().split(" ");

        for(int i=0; i<m.length; i++){
            set.add(m[i]);
        }

        int K = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");

        for(int i=0; i<data.length; i++){
            if(set.contains(data[i])){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
