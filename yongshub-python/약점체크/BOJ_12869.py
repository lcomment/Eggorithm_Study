import sys
from itertools import permutations
input = sys.stdin.readline
cases = list(permutations([9, 3, 1]))
dp = [[[-1 for _ in range(61)] for _ in range(61)] for _ in range(61)]
N = int(input().rstrip())
scv = list(map(int, input().split()))
temp = [0] * 3
for i in range(N):
    temp[i] = scv[i]


def dfs(a, b, c):
    if a < 0:
        return dfs(0, b, c)
    if b < 0:
        return dfs(a, 0, c)
    if c < 0:
        return dfs(a, b, 0)
    
    if a == 0 and b == 0 and c == 0:
        return 0
    
    dp[a][b][c] = int(10e9)
    for case in cases:
        dp[a][b][c] = min(dp[a][b][c], dfs(a - case[0], b - case[1], c - case[2]))
    dp[a][b][c] += 1
    return dp[a][b][c]

print(dfs(temp[0], temp[1], temp[2]))

