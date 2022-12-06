import java.io.*;
import java.util.*;

public class BOJ_19941 {
    static boolean[] check;
    static List<String> list;
    static int N;
    static int M;
    static int answer = 0;
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0];
        M = NM[1];

        check = new boolean[N];
        String data = br.readLine();
        for(int i=0 ; i<N; i++){
            list.add(String.valueOf(data.charAt(i)));
            if(list.get(i).equals("P")) check[i] = true;
        }

        while(index != N){
            int num = 0;
            if(list.get(index).equals("P")) {
                num = index;
                for(int i=num-M ; i<=num+M; i++){
                    if(i >= 0 && i <=N-1 && !check[i]) {
                        check[i]=true;
                        answer++;
                        break;
                    }
                }
            }
            index++;
        }
        System.out.println(answer);
    }
}