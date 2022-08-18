import sys
input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
    arr = []
    # 2 * N 배열 입력 받기
    N = int(input().rstrip())
    for _ in range(2):
        arr.append(list(map(int, input().split())))
    dp = [[0] * (N + 1) for _ in range(2)]
    dp[0][0] = arr[0][0]
    dp[1][0] = arr[1][0]

    for i in range(N - 1):
        if i < N - 2:
            dp[1][i + 1] = max(dp[1][i + 1], dp[0][i] + arr[1][i + 1])
            dp[1][i + 2] = max(dp[1][i + 2], dp[0][i] + arr[1][i + 2])
        else:
            dp[1][i + 1] = max(dp[1][i + 1], dp[0][i] + arr[1][i + 1])
            
        if i < N - 2:
            dp[0][i + 1] = max(dp[0][i + 1], dp[1][i] + arr[0][i + 1])
            dp[0][i + 2] = max(dp[0][i + 2], dp[1][i] + arr[0][i + 2])
        else:
            dp[0][i + 1] = max(dp[0][i + 1], dp[1][i] + arr[0][i + 1])
    print(max(dp[0][N - 1], dp[1][N - 1]))