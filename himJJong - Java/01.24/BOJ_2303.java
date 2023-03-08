import java.io.*;
import java.util.*;

public class BOJ_2303 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int people = Integer.parseInt(br.readLine());
        int[][] data = new int[people][5];

        for(int i=0; i<people; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[] result = new int[people];
        for(int i=0; i<people; i++){
            result[i] = check(data[i]);
        }


        int max = result[0];
        int answer = 0;
        for(int i=1; i<result.length; i++){
            if(max > result[i]){
                continue;
            }
            else{
                max = result[i];
                answer = i;
            }
        }
        System.out.println(answer+1);
    }

    private static int check(int[] dataGroup) {
        int max = 0;

        for(int i=0; i<dataGroup.length-2; i++){
            for(int j=i+1; j<dataGroup.length-1; j++){
                for(int k=j+1; k<dataGroup.length; k++){
                    max = Math.max(max, (dataGroup[i]+dataGroup[j]+dataGroup[k])%10);
                }
            }
        }
        return max;
    }
}
