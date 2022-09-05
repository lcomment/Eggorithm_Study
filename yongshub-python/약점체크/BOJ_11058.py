import sys
input = sys.stdin.readline

n = int(input().rstrip())
dp = [[0] * (n + 1) for _ in range(3)] # 0행 붙이기, 1행 전체 선택, 2행 복사하기
dp[0][0] = 1
is_select = False
for i in range(1, n):
    for j in range(3):
        if j == 0: # 붙이기
            dp[j][i] = max(dp[j][i - 1] + 1, dp[j][i - 3] + dp[j + 1][i - 1])
        elif j == 1: # 복사하기
            if is_select:
                dp[j][i] = dp[j + 1][i - 1]
        else:
            is_select = True
            dp[j][i] = dp[0][i - 1]
print(dp[0][n - 1])