class programmers_changeNumber {
    private static final int MAX = Integer.MAX_VALUE;

    public static int solution(int x, int y, int n) {
        int answer = 0;

        int[] dp = new int[y + 1];

        for (int i = x + 1; i < y + 1; i++) {
            int a = MAX, b = MAX, c = MAX, d;

            if (isDivided(i, 2) && aboveX(x, i / 2)) a = dp[i / 2];
            if (isDivided(i, 3) && aboveX(x, i / 3)) b = dp[i / 3];
            if (aboveX(x, i - n)) c = dp[i - n];

            // 숫자 i를 만들기 위한 최소 방법을 찾음
            d = Math.min(a, b);
            d = Math.min(d, c);

            // 만들 수 있으면 d+1 저장
            // 만들 수 없다면 MAX 저장
            dp[i] = (d < MAX) ? d + 1 : MAX;
        }

        // y를 만들 수 없다면 -1 반환
        answer = (dp[y] < MAX) ? dp[y] : -1;

        return answer;
    }

    // x 보다 작은 위치의 값을 비교하지 않게 함
    private static boolean aboveX(int x, int num) {
        return (num >= x);
    }

    //  (i / 2), (i / 3)의 연산 결과가 자연수인지 확인함
    private static boolean isDivided(int num, int divide) {
        return (num / divide > 0 && num % divide == 0);
    }
}