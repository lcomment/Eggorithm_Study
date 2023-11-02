import java.io.*;
import java.util.*;

public class softeer_box {
    static int rail;
    static int limit;
    static int spin;
    static int[] data;
    static int[] answer;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rail = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        spin = Integer.parseInt(st.nextToken());

        data = new int[rail];
        answer = new int[rail];
        visited = new boolean[rail];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<rail; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0,0);
        System.out.println(min);
    }

    private static void backTracking(int count, int at){
        if(count == rail){
            min = Math.min(min, check());
            return;
        }
        for(int i=0; i<rail; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[at] = data[i];
                backTracking(count+1, at+1);
                answer[at] = 0;
                visited[i] = false;
            }
        }
    }

    private static int check(){
        int tmp = spin;
        int result = 0;
        int index = 0;
        while(tmp -- >0){
            int sum = 0;
            while(sum + answer[index] <= limit) {
                sum += answer[index];
                index++;
                if (index == rail) {
                    index = 0;
                }
            }
            result += sum;
        }
        return result;
    }
}
