import java.util.*;
import java.io.*;

public class codeTree_twopointer {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] data = new int[N+1];

        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        int j =0;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i=1; i<=N; i++){
            while(j+1 <=N){
                if(!h.containsKey(data[j+1])){
                    h.put(data[j+1],0);
                    j++;
                }
                else break;
            }
            answer = Math.max(answer, j-i+1);
            h.remove(data[i]);
        }
        System.out.println(answer);
    }
}