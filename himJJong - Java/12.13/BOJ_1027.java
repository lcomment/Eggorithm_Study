import java.io.*;
import java.util.*;

public class BOJ_1027 {
    static int count;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        count = Integer.parseInt(br.readLine());

        double[] data = new double[count];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<data.length; i++){
            data[i] = Long.parseLong(st.nextToken());
        }

        for(int i=0; i<data.length; ++i){
            int left = leftCheck(i,data);
            int right = rightCheck(i,data);
            answer = Math.max(answer, left+right);
        }
        System.out.println(answer);
    }
    // 기울기를 max 값을 두고 비교하면서,
    private static int leftCheck(int index, double[] data) {  //해당 인덱스-1 부터 왼쪽 끝까지
        int result = 0;
        double save = 0;

        for(int i=index-1; i>=0; --i){
            double val = (data[index]-data[i]) / (index - i);
            if(i == index -1 || save > val) {
                result++;
                save = val;
            }
        }
        return result;
    }

    private static int rightCheck(int index, double[] data) { // 해당 인덱스+1 부터 오른쪽 끝까지
        int result = 0;
        double save = 0;

        for(int i=index+1; i<count;++i){
            double val = (data[i]-data[index]) / (i- index);
            if(i == index+1 || save < val) {
                result++;
                save = val;
            }
        }
        return result;
    }
}