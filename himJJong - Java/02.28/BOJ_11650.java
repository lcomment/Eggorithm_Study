import java.util.*;
import java.io.*;

public class BOJ_11650 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[][] data = new int[count][2];

        for(int i=0; i<data.length; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[0] == e2[0]) {
                    return e1[1] - e2[1];
                } else {
                    return e1[0] - e2[0];
                }
            }
        });

        for(int i=0; i<count; i++){
            System.out.println(data[i][0] +" "+ data[i][1]);
        }

    }
}
