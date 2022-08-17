import sys
input = sys.stdin.readline

N = int(input().rstrip())
arr = [0] * 302
for i in range(1, N + 1):
    arr[i] = int(input().rstrip())

dp = [[0] * 3 for _ in range(302)]
dp[1][1] = arr[1]
dp[2][1] = arr[2]

for i in range(0, N):
    for j in range(1, 3):
        if dp[i][j] > 0:
            if j == 1:
                dp[i + 1][2] = max(dp[i + 1][2], dp[i][j] + arr[i + 1])
                dp[i + 2][1] = max(dp[i + 2][1], dp[i][j] + arr[i + 2])
            else:
                dp[i + 2][1] = max(dp[i + 2][1], dp[i][j] + arr[i + 2])
print(max(dp[N]))                