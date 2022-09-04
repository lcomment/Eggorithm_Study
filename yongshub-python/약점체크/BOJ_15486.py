import sys
input = sys.stdin.readline

N = int(input().rstrip())
arr = [0 for _ in range(N + 1)]
dp = [0] * (N + 1)
for i in range(1, N + 1):
    arr[i] = tuple(map(int, input().split()))
for i in range(1, N + 1):
    day, price = arr[i]
    if i + day - 1 <= N:
        dp[i + day - 1] = max(dp[i + day - 1], price + dp[i - 1])
    if dp[i - 1] > 0:
        dp[i] = max(dp[i - 1], dp[i])
print(dp[-1])