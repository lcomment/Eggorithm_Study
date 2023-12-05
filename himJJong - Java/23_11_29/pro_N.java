import java.util.*;

class pro_N {
    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2,11));
    }
    public static int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        for (int i = 2; i <= 8; i++) {  // N의 개수 i개 일때
            StringBuilder sb = new StringBuilder().append(N);

            for (int j = 1; j < i; j++) {
                sb.append(N);
            }

            dp.get(i).add(Integer.parseInt(sb.toString()));

            for (int j = 1; j < i; j++) {
                int k = i - j;                      // i가 3 이라면
                for (int num1 : dp.get(j)) {        // sb = "555" , k = 3 - 1 = 2;
                    for (int num2 : dp.get(k)) {    //              k = 3 - 2 = 1;
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
}

