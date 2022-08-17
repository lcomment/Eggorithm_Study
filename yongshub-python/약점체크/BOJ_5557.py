import sys
input = sys.stdin.readline

N = int(input().rstrip())
arr = list(map(int, input().split()))
dp = [[0] * 21 for _ in range(N + 1)]

dp[1][arr[0]] = 1

for i in range(1, N):
    for j in range(21):
        if dp[i][j] >= 1:
            if 0 <= j + arr[i] <= 20:
                dp[i + 1][j + arr[i]] += dp[i][j]
            
            if 0 <= j - arr[i] <= 20:
                dp[i + 1][j - arr[i]] += dp[i][j]
print(dp[N - 1][arr[N - 1]])
