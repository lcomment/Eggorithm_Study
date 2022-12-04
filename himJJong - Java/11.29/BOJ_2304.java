import java.io.*;
import java.util.*;

public class BOJ_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int[][] data = new int[count][2];

        for(int i=0; i<count ; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());;
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        // x축의 데이터 값대로 오름차순 정렬
        Arrays.sort(data, Comparator.comparingInt(o -> o[0]));

        int area = 0;

        //i는 현재 기둥, j는 i다음 기둥부터 끝까지의 기둥 중 하나, max는 현재 기둥보다 작은 것들 중 제일 큰 값
        for(int i=0; i<count; ){
            int j = i+1;
            int max = j;

            //while j 값이 전체 count보다 작으면서 현재 기둥 높이가 j기둥 높이보다 크다면 실행
            //만약 max기둥 높이가 다다음 기둥 높이보다 작다면 max값을 j-1로 수정
            while(j<count && data[i][1]>data[j][1]){
                if(data[max][1]<data[j++][1]) max = j - 1;
            }

            if(j>=count) {  // j가 N보다 크거나 같다면 i번째 기둥보다 큰 기둥이 없는 경우
                area += data[i][1];
                if(max < count) area += data[max][1] * (data[max][0] - data[i][0]-1);
                i = max;
            }
            else{ // j가 N보다 작다면 i번째 기둥보다 큰 기둥이 있는 경우
                area += data[i][1] * (data[j][0] - data[i][0]);
                i = j;
            }
        }

        System.out.println(area);
    }
}