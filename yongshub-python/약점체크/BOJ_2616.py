import sys

input = sys.stdin.readline
n = int(input())
car = list(map(int, input().split()))
car.insert(0, 0)
carry = int(input())
# dp에는 기관차 수와 객차 번호에 해당하는 인덱스에 최대 손님 수 저장
# dp[N][M] = 100, 기관차 N개를 써서 M번 번호 객차까지 최대 손님수가 100명
dp = [[0] * (n + 1) for _ in range(4)]
# total에는 1번객차부터 n번까지 총 인원수가 들어있다.
# 기관차가 최대 2개 이상의 객차를 끌 수도 있으므로 계산편의상 이렇게 하는게 편하다.
total = [0]
for i in range(1, n + 1):
    total.append(total[i - 1] + car[i])

for i in range(1, 4):
    for j in range(carry, n + 1):
        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - carry] + total[j] - total[j - carry])
print(dp[3][n])