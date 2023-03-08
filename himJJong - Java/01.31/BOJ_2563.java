import java.util.*;
import java.io.*;

public class BOJ_2563 {
    static boolean[][] map = new boolean[100][100];
    static int[][] paperData;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperCount = Integer.parseInt(br.readLine());
        int answer = 0;

        paperData = new int[paperCount][2];

        for(int i=0; i<paperCount; i++){
            paperData[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<paperCount; i++){
            for(int j=0; j<100; j++){
                for(int k=0 ; k<100; k++){
                    if(!map[j][k] && check(i,j,k)){ // i는 paperCount인덱스, j,k 는 좌표
                        map[j][k] = true;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean check(int index, int x, int y) {
        if(paperData[index][0] <= x && paperData[index][0]+10 > x && paperData[index][1] <= y && paperData[index][1]+10 > y){
            return true;
        }
        return false;
    }
}
