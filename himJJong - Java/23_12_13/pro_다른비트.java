import java.util.Arrays;

public class pro_다른비트 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{2, 7})));
    }

    public static long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        return answer;
    }
}