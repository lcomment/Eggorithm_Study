import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<arr.length;j++){
                alpha[(int)arr[j].charAt(0) - 65] += (int) Math.pow(10,arr.length-(j+1));
            }
        }

        Arrays.sort(alpha);

        int index = 25;
        int number = 9;
        int sum = 0;
        while(true){
            if(alpha[index] == 0)   break;

            sum += number * alpha[index];
            index--;
            number--;
        }
        System.out.println(sum);
    }
}
