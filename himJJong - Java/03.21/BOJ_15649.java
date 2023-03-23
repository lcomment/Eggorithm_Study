import java.io.*;
import java.util.Arrays;

public class BOJ_15649 {
    static StringBuilder sb = new StringBuilder();
    static int[] NM;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        visited = new boolean[NM[0]];
        backTracking(0);
        System.out.println(sb);
    }

    private static void backTracking(int index) {
        if(index == NM[1]){
            for(int i=0; i<NM[0];i++){
                if(visited[i])  sb.append(i+1).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<NM[0];i++){
            if(!visited[i]){
                visited[i]=true;
                backTracking(index+1);
                visited[i] = false;
            }
        }
    }
}
