import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N -- >0) {
            int count = 0;
            String input = br.readLine();
            StringBuilder sb = new StringBuilder(input);

            if(sb.toString().equals(sb.reverse().toString())){
                System.out.println(0);
                continue;
            }
            int left = 0;
            int right = input.length() - 1;
            while (left < right) {
                if(sb.charAt(left) == sb.charAt(right)){
                    left++;
                    right--;
                    continue;
                }
                StringBuilder delLeft = new StringBuilder(input).deleteCharAt(left);
                StringBuilder delRight = new StringBuilder(input).deleteCharAt(right);

                if(delLeft.toString().equals(delLeft.reverse().toString()) || delRight.toString().equals(delRight.reverse().toString())){
                    System.out.println(1);
                    break;
                }
                else{
                    System.out.println(2);
                    break;
                }
            }
        }
    }
}
