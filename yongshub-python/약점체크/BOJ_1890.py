import sys
input = sys.stdin.readline
N = int(input().rstrip())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * N for _ in range(N)]
nx_1, ny_1 = 0 + arr[0][0], 0
nx_2, ny_2 = 0, 0 + arr[0][0]
if 0 <= nx_1 < N and 0 <= ny_1 < N:
    dp[nx_1][ny_1] = dp[nx_1][ny_1] + 1
if 0 <= nx_2 < N and 0 <= ny_2 < N:
    dp[nx_2][ny_2] = dp[nx_2][ny_2] + 1 
for i in range(N):
    for j in range(N):
        if dp[i][j] > 0:
            if arr[i][j] == 0:
                break
            nx_1, ny_1 = i + arr[i][j], j
            nx_2, ny_2 = i, j + arr[i][j]
            if 0 <= nx_1 < N and 0 <= ny_1 < N:
                dp[nx_1][ny_1] = dp[nx_1][ny_1] + dp[i][j]
            if 0 <= nx_2 < N and 0 <= ny_2 < N:
                dp[nx_2][ny_2] = dp[nx_2][ny_2] + dp[i][j]
print(dp[N-1][N-1])