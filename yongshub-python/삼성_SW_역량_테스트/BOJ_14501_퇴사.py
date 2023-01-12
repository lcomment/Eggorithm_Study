# 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
# 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
# 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
# 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.

# 7
# 3 10
# 5 20
# 1 10
# 1 20
# 2 15
# 4 40
# 2 200

import sys

input = sys.stdin.readline

N = int(input().rstrip()) # 남은 N일
dp = [0] * (1001)
datas = []

for _ in range(N):
    datas.append(tuple(map(int, input().split())))

for i in range(N):
    days, price = datas[i]
    dp[i + days] = max(dp[i + days], dp[i] + price)
    dp[i + 1] = max(dp[i + 1], dp[i])

print(dp[N])

