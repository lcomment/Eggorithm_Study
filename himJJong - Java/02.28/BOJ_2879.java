import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2879 {
    static int[] diff;
    static int prev = 0;
    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        int[] myData = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] answerData = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        diff = new int[count];

        for (int i = 0; i < count; i++) {
            diff[i] = myData[i] - answerData[i];
        }

        prev = diff[0];
        for (int i = 1; i < count; i++) {
            if(prev*diff[i]<0){
                answer += Math.abs(prev);
            }
            else if(Math.abs(prev)>=Math.abs(diff[i])){
                answer += Math.abs(prev)-Math.abs(diff[i]);
            }
            prev = diff[i];
        }
        answer += Math.abs(prev);
        System.out.println(answer);
    }
}