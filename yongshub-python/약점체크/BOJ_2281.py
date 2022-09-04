import sys
input = sys.stdin.readline
dp = [int(1e9)] * 1001
arr = []
n, m = map(int, input().split())


def solution(idx):
    global n, m
    if dp[idx] < int(1e9):
        return dp[idx]

    remain = m - arr[idx]
    for i in range(idx + 1, n + 1):
        if remain < 0:
            break
        if i == n:
            dp[idx] = 0
            break
        dp[idx] = min(dp[idx], remain * remain + solution(i))
        remain -= arr[i] + 1
    return dp[idx]

    
for _ in range(n):
    arr.append(int(input().rstrip()))
print(solution(0))