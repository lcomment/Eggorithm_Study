import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2529 {
    static String[] data;
    static int N;
    static int[] answer;
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        data = br.readLine().split(" ");

        answer = new int[N+1];

        backTracking(0);
        System.out.println(max);
        if(data[0].equals("<")) System.out.println("0"+min);
        else System.out.println(min);
    }

    private static void backTracking(int depth) {
        if(depth == N+1){
            for(int i=0; i<answer.length; i++){
                sb.append(answer[i]);
            }
            min = Math.min(Long.parseLong(sb.toString()), min);
            max = Math.max(Long.parseLong(sb.toString()), max);
            sb.setLength(0);
            return;
        }

        for(int i=0; i<10; i++){
            if(depth == 0){
                answer[depth] = i;
                visited[i] = true;
                backTracking(depth+1);
                visited[i] = false;
            }
            else if(!visited[i] && check(depth,i)){
                visited[i] = true;
                answer[depth] = i;
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int depth, int compare) {
        int prev = answer[depth-1];
        int tmp = compare;

        if(data[depth-1].equals(">")){
            if(prev > tmp)  return true;
            return false;
        }
        if(data[depth-1].equals("<")){
            if(prev < tmp)  return true;
            return false;
        }

        return false;
    }
}
