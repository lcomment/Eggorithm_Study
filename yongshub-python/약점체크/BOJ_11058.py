import sys
input = sys.stdin.readline
n = int(input())
dp = [i for i in range(0, 102)]

for i in range(6, 101):
    dp[i] = max(dp[i-3]*2, max(dp[i-4]*3, dp[i-5]*4))
print(dp[n])