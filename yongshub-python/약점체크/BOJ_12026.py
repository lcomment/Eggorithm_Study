import sys
input = sys.stdin.readline
n = int(input().rstrip())
letters = input().rstrip()
dp = [int(10e9)] * (n + 1)
dp[0] = 0
maps = dict()
maps['B'] = 'J'
maps['O'] = 'B'
maps['J'] = 'O'
for i in range(1, n):
    prev = maps[letters[i]]
    for j in range(i):
        if letters[j] == prev:
            dp[i] = min(dp[i], dp[j] + pow(i - j, 2))
print(dp[n - 1] if dp[n - 1] != int(10e9) else -1)