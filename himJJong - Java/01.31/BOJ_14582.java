import java.util.*;
import java.io.*;

public class BOJ_14582 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] aTeam = new int[1][18];
        int[][] bTeam = new int[1][18];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<18; i+=2){
            aTeam[0][i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<18; i+=2){
            bTeam[0][i] = Integer.parseInt(st.nextToken());
        }

        int aPoint = 0;
        int bPoint = 0;
        boolean check = false;

        for(int i=0; i<18; i++) {
            aPoint += aTeam[0][i];
            if(aPoint > bPoint) {
                check = true;
                break;
            }
            bPoint += bTeam[0][i];
        }
        if(check) System.out.println("Yes");
        else System.out.println("No");
    }
}
