package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15665 {

    static boolean[] visited;
    static int[] answer;
    static int limit;
    static int dataSize;
    static StringBuilder sb = new StringBuilder();
    static int[] data;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dataSize = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        visited = new boolean[dataSize];
        answer = new int[limit];


        st = new StringTokenizer(br.readLine());

        data = new int[dataSize];

        for(int i=0; i<dataSize; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        backTracking(0,0);

        System.out.print(sb);
    }

    private static void backTracking(int at,int depth) {
        if(depth== limit){
            StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<answer.length; i++){
                sb2.append(answer[i]).append(" ");
            }
            if(!set.contains(sb2.toString())){
                sb.append(sb2).append("\n");
                set.add(String.valueOf(sb2));
            }
            return;
        }

        for(int i=at; i<dataSize; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = data[i];
                backTracking(i,depth+1);
                visited[i] = false;
            }
        }
    }
}
