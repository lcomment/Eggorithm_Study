import java.util.*;
public class pro_n진수 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(2,2,2,2));
    }
    static class Solution {
        public static String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int i = 0; count < t * m; i++) {
                String converted = convertToBase(i, n);
                sb.append(converted);
                count += converted.length();
            }

            char[] chars = sb.toString().toCharArray();
            for (int i = p - 1; i < t * m; i += m) {
                answer.append(Character.toUpperCase(chars[i]));
            }

            return answer.toString();
        }

        // 숫자를 n진수로 변환하는 함수
        public static String convertToBase(int number, int base) {
            StringBuilder sb = new StringBuilder();
            while (number > 0) {
                int remainder = number % base;
                if (remainder >= 10 && remainder <= 15) {
                    sb.insert(0, (char) ('A' + remainder - 10));
                } else {
                    sb.insert(0, remainder);
                }
                number /= base;
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }

}


