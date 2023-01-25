import java.io.*;
import java.util.*;

public class BOJ_15650 {
    static int[] data;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        data = new int[2];
        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        arr = new int[data[1]];

        backTracking(1,0);
        System.out.println(sb);
    }

    private static void backTracking(int at,int limit) {
        if(limit == data[1]){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=at; i<=data[0]; i++){
            arr[limit] = i;
            backTracking(i+1, limit+1);
        }
    }
}
