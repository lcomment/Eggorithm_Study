import java.util.*;
import java.io.*;

public class codeTree_bruteforce {
    static int limit = 0;
    static int[] seq;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int answer = 0;
        limit = Integer.parseInt(tmp[1]);

        int[][] map = new int[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[0])];
        seq = new int[Integer.parseInt(tmp[0])];

        for(int i=0; i<Integer.parseInt(tmp[0]); i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        if(Integer.parseInt(tmp[0]) == 1){
            System.out.println(2);
            System.exit(0);
        }

        for(int i=0; i<Integer.parseInt(tmp[0]); i++){
            for(int j=0; j<Integer.parseInt(tmp[0]); j++){
                seq[j] = map[i][j];
            }
            if(check()){
                answer++;
            }
        }

        for(int j=0; j<Integer.parseInt(tmp[0]); j++){
            String str = "";
            for(int i=0; i<Integer.parseInt(tmp[0]); i++){
                seq[i] = map[i][j];
            }
            if(check()){
                answer++;
            }
        }

        System.out.println(answer);
    }
    public static boolean check(){
        int check = 1;
        int max = 1;
        for(int i=0; i<seq.length-1; i++){
            if(seq[i] == seq[i+1]){
                check++;
            }

            else{
                check = 1;
            }
            max = Math.max(max, check);
        }
        return max >= limit;
    }
}