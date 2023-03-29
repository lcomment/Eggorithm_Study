import java.util.*;
import java.io.*;

public class BOJ_1946 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++){
            int answer = 0;
            int dataCount = Integer.parseInt(br.readLine());
            int[][] data = new int[dataCount][2];

            for(int j=0; j<dataCount; j++){
                data[j] = Arrays.stream(br.readLine().split(" "))
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

            int init = data[0][1];
            for(int j=1; j<data.length;j++){
                if(data[j][1] < init) {
                    answer++;
                    init = data[j][1];
                }
            }
            sb.append(answer+1).append("\n");
        }
        System.out.print(sb);
    }
}
