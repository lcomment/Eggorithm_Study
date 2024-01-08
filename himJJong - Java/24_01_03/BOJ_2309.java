import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2309 {
    static int[] data;
    static boolean[] visited;
    static int[] answer;
    static int sum;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        data = new int[9];
        answer = new int[7];
        visited = new boolean[9];

        for(int i=0; i<9; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        btk(0, 0);
    }

    private static void btk(int index, int at) {
        if(index ==  7){
            if(sum == 100){
                Arrays.sort(answer);
                for(int i=0; i<7; i++){
                    System.out.println(answer[i]);
                }
                System.exit(0);
            }
            return;
        }

        for(int i=0; i<9; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[at] = data[i];
                sum+= data[i];
                btk(index+1, at+1);
                visited[i] = false;
                sum -= data[i];
            }
        }
    }
}
