import sys
from collections import deque
input = sys.stdin.readline
N, S, M = map(int, input().split())
v = deque(list(map(int, input().split())))
v.appendleft(S)
dp = [[-1] * (M + 1) for _ in range(N + 1)]
dp[0][S] = S
check = True
for i in range(1, N + 1):
    cnt = 0
    for j in range(M + 1):
        if dp[i - 1][j] >= 0:
            cnt += 1
            if 0 <= dp[i - 1][j] + v[i] <= M:
                dp[i][j + v[i]] = j + v[i]
            if 0<= dp[i - 1][j] - v[i] <= M:
                dp[i][j - v[i]] = j - v[i]
    if cnt == 0:
        check = False
        break

if not check:
    print(-1)
else:
    print(max(dp[N]))