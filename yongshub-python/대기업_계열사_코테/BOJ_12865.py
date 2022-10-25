import sys
input = sys.stdin.readline
# N개의 물건, 각 물건은 무게 W와 가치 V 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
# 최대 K만큼의 무게만을 넣을 수 있는 배낭, 가치의 최대값을 알려주자
N, K = map(int, input().split())
cases = [tuple(map(int, input().split())) for _ in range(N)]
cases.insert(0, (0, 0))
dp = [[0] * (K + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, K + 1):
        weight, value = cases[i][0], cases[i][1]
        if j < weight:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(value + dp[i - 1][j - weight], dp[i - 1][j])
print(dp[N][K])
