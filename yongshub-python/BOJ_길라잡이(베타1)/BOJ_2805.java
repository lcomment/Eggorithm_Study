import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_2805 {
    static List<Long> trees = new ArrayList<>();
    static long maxValue = 0;
    static int N;
    static long M;
    static long answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        inputValues(br); // 나무 높이 입력 받기
        Collections.sort(trees); // 나무 높이들 오름차순으로 정렬
        binarySearch(0, maxValue);
        System.out.println(answer);
    }

    public static void inputValues(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            long number = Long.parseLong(st.nextToken());
            maxValue = Math.max(maxValue, number);
            trees.add(number);
        }
    }

    public static void binarySearch(long start, long end) {
        long middle = (start + end) / 2;
        long sum = 0;

        for(int i = 0; i < N; i++) {
            if(trees.get(i) > middle) {
                sum += (trees.get(i) - middle);
            }
        }

        if (sum == M) {
            answer = Math.max(answer, middle);
        }

        if(start <= end){
            if(sum > M) {
                answer = Math.max(middle, answer);
                binarySearch(middle + 1, end);
            } else {
                binarySearch(start, middle - 1);
            }
        }
    }
}