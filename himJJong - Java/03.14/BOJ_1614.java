import java.util.*;
import java.io.*;

public class BOJ_1614 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sickFinger = Integer.parseInt(br.readLine());
        long limit = Long.parseLong(br.readLine());

        if(sickFinger == 1){
            System.out.println(8*limit);
        }
        else if(sickFinger == 2){
            System.out.println(1+(limit/2*8)+((limit%2)*6));
        }
        else if(sickFinger == 3){
            System.out.println(2+(4*limit));
        }
        else if(sickFinger == 4){
            System.out.println(3+(limit/2*8)+((limit%2)*2));
        }
        else if(sickFinger == 5){
            System.out.println(4+(8*limit));
        }
    }
}
