import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1 <= N <= 200000
// 1 <= M <= 200000
// -1000000000 <= Ai <= 1000000000
// -1000000000 <= D <= 1000000000
public class BOJ_20551 {
    static int N, M;
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> finds = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputValues(arr, N, br); // 배열 요소 입력 받기
        inputValues(finds, M, br); // 찾고 싶은 M개의 질문들 받기
        Collections.sort(arr); // 오름차순으로 정렬

        for(int i = 0; i < M; i++) {
            int index = binarySearch(0, N - 1, finds.get(i));
            if(index == -1) {
                sb.append("-1\n");
            } else if(index == 0) {
                sb.append("0\n");
            } else {
                while(true) {
                    int result = binarySearch(0, index - 1, finds.get(i));
                    if(result == -1) {
                        break;
                    } else if(result == 0) {
                        index = 0;
                        break;
                    }
                    index = Math.min(index, result);
                }
                sb.append(String.format("%d\n", index));
            }
        }
        System.out.print(sb);
    }

    public static void inputValues(List<Integer> list, int length,  BufferedReader br) throws Exception {
        for(int i = 0; i < length; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
    }

    public static int binarySearch(int start, int end, int number) {
        int middle = (start + end) / 2;

        if(arr.get(middle) == number) {
            return middle;
        }

        if(start <= end) {
            if(arr.get(middle) < number) {
                return binarySearch(middle + 1, end, number);
            }else if(arr.get(middle) > number) {
                return binarySearch(start, middle - 1, number);
            }
        }
        return -1;
    }
}