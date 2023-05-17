import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class softeer_average {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());

        int[] score = new int[people+1];
        int[][] inputData = new int[input+1][2];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=people; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=input; i++){
            st = new StringTokenizer(br.readLine());

            inputData[i][0] = Integer.parseInt(st.nextToken());
            inputData[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=input; i++){
            int a = inputData[i][0];
            int b = inputData[i][1];
            double sum =0;
            for(int j=a ; j<=b; j++){
                sum +=score[j];
            }
            System.out.println(Math.round(((sum*100)/(b-a+1))) / 100.0);
        }
    }
}
