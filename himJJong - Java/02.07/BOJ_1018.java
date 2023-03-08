import java.util.*;
import java.io.*;

public class BOJ_1018 {
    static String black = "B";
    static String white = "W";
    static int answer = Integer.MAX_VALUE;
    static int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM;

        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] data = new String[NM[0]][NM[1]];

        for(int i=0; i<NM[0]; i++){
            data[i] = br.readLine().split("");
        }

        for(int i=0; i<=NM[0]-8; i++){
            for(int j=0; j<=NM[1]-8; j++){

                int index = i+j;    // 0~63번째 체크를 위한 변수

                if(data[i][j].equals(black)){   // 0번째가 "B"라면
                    for(int k=i; k<i+8; k++) {
                        for (int l=j; l<j+8; l++) {
                            if (((k + l) - index) % 2 == 0 && data[k][l].equals(white)) count++;
                            else if (((k + l) - index) % 2 == 1 && data[k][l].equals(black)) count++;
                        }
                    }
                    saveAnswer(count);

                    for(int k=i; k<i+8; k++){
                        for(int l=j; l<j+8; l++) {
                            if (((k + l) - index) % 2 == 0 && data[k][l].equals(black)) count++;
                            else if (((k + l) - index) % 2 == 1 && data[k][l].equals(white)) count++;
                        }
                    }
                    saveAnswer(count);
                }

                else{                           // 0번째가 W라면
                    for(int k=i; k<i+8; k++){
                        for(int l=j; l<j+8; l++){
                            if(((k+l)-index)%2==0 && data[k][l].equals(black)) count++;
                            else if(((k+l)-index)%2==1 && data[k][l].equals(white)) count++;
                        }
                    }
                    saveAnswer(count);

                    for(int k=i; k<i+8; k++){
                        for(int l=j; l<j+8; l++){
                            if(((k+l)-index)%2==0 && data[k][l].equals(white)) count++;
                            else if(((k+l)-index)%2==1 && data[k][l].equals(black)) count++;
                        }
                    }
                    saveAnswer(count);
                }
            }
        }
        System.out.println(answer);
    }

    private static void saveAnswer(int value) {
        answer = Math.min(answer,value);
        count = 0;
    }
}
