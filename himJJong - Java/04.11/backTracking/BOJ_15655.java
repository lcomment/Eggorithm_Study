package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {
    static boolean[] visited;
    static int[] answer;
    static int limit;
    static int dataSize;
    static StringBuilder sb = new StringBuilder();
    static int[] data;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dataSize = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        visited = new boolean[dataSize+1];
        answer = new int[limit];


        st = new StringTokenizer(br.readLine());

        data = new int[dataSize+1];

        for(int i=1; i<=dataSize; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        for(int i=1 ;i<=dataSize; i++){
            visited[i] = true;
            answer[0] = data[i];
            backTracking(i,0);
            visited[i] = false;
        }

        System.out.print(sb);
    }

    private static void backTracking(int at,int depth) {
        if(depth+1 == limit){
            for(int i=0; i<answer.length; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<=dataSize; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth+1] = data[i];
                backTracking(i,depth+1);
                visited[i] = false;
            }
        }

    }
}
