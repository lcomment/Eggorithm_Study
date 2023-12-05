public class pro_N개의최소공배수 {

    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(Solution.solution(arr));
    }
    static class Solution {
        public static int solution(int[] arr) {
            int answer = arr[0];

            for (int i = 1; i < arr.length; i++) {
                answer = lcm(answer, arr[i]);
            }
            return answer;
        }

        // 최대공약수
        public static int gcd(int a, int b) {
            if (a % b == 0) {
                return b;
            }
            return gcd(b, a % b);
        }

        // 최소공배수
        private static int lcm(int a, int b) {
            return a * b / gcd(a, b);
        }
    }
}
