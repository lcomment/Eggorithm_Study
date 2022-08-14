## 시작 숫자는 S부터 1씩 증가
# 공백의 시작은 N - 1개부터 1씩 감소
# 짝수번째 행은 왼 ->오 1씩 증가
# 홀수번째 행은 거꾸로
import sys
input = sys.stdin.readline
from collections import deque
N, S = map(int, input().split())

for i in range(1, N + 1):
  #짝수
  if i % 2 == 0:
    line = ''
    print(' ' * (N - i), end='')
    for j in range(2*i - 1):
      if S == 10:
        S = 1
      line = line + str(S)
      S += 1
    print(line)
  else:
    line = ''
    print(' ' * (N - i), end='')
    for j in range(2*i - 1):
      if S == 10:
        S = 1
      line = str(S) + line
      S += 1
    print(line)
