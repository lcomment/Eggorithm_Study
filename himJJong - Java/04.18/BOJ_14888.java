import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_14888 {
    static int[] data;
    static int[] calData;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int testcase;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testcase = Integer.parseInt(br.readLine());

        data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        calData = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        backTracking(data[0], 1);


        System.out.println(max);
        System.out.println(min);
    }

    private static void backTracking(int num, int depth) {
        if(depth == testcase){
            min = Math.min(min,num);
            max = Math.max(max,num);
            return;
        }

        for(int i=0; i<4; i++){
            if(calData[i] > 0){
                calData[i]--;
                if(i==0){
                    backTracking( num + data[depth],depth+1);
                }
                else if(i==1){
                    backTracking( num - data[depth],depth+1);
                }
                else if(i==2){
                    backTracking( num * data[depth],depth+1);
                }
                else if(i==3){
                    backTracking( num / data[depth],depth+1);
                }
                calData[i]++;
            }
        }
    }
}








