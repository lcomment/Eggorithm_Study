import java.io.*;
import java.util.*;

public class BOJ_15654 {
    static int count;
    static int limit;
    static int[] data;
    static int[] arr;
    static boolean[] vistied;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        vistied = new boolean[count];

        data = new int[count];
        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(data);
        arr = new int[limit];
        backTracking(0);
        System.out.println(sb);
    }

    private static void backTracking(int depth) {
        if(depth == limit){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<count; i++){
            if(!vistied[i]){
                vistied[i] = true;
                arr[depth] = data[i];
                backTracking(depth+1);
                vistied[i] = false;
            }

        }
    }
}
