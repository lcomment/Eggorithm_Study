import java.io.*;
import java.util.*;


public class BOJ_1911 {
    static int[][] data;
    static int count;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        data = new int[count][2];
        for(int i=0; i<count; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Arrays.sort(data, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int nulpan = 0;	// 필요한 널빤지의 개수
        int range = 0;	// 널빤지를 물웅덮이에 덮었을때, 덮을 수 있는 범위

        for(int i=0; i<count; i++) {
            if(data[i][0] > range)
                range = data[i][0];
            if(data[i][1] >= range) {
                while(data[i][1] > range) {
                    range += length;
                    nulpan ++;
                }
            }
        }
        System.out.println(nulpan);
    }
}
