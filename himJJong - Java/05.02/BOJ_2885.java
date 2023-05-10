import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2885 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int checkSize = 1;
        int count = 0;

        while(checkSize < input) {
            checkSize = checkSize * 2;
        }

        int chocolateSize = checkSize;

        while(input > 0) {
            if(input>=checkSize) {
                input-=checkSize;
            }else {
                checkSize /= 2;
                count++;
            }
        }
        System.out.println(chocolateSize+" " + count);
    }
}
