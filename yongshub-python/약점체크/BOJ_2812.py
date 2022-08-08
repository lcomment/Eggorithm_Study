#시간초과 코드
# import sys
# input = sys.stdin.readline
# from itertools import combinations
# N, K = map(int, input().split())
# number = 0
# numbers = list(map(int, input().rstrip()))
# for comb in combinations(numbers, N - K):
#     number = max(number, int(''.join(map(str, comb))))
# print(number)

import sys
input = sys.stdin.readline
from collections import deque
N, K = map(int, input().split())
numbers = list(map(int, input().rstrip()))
result = deque([0])
length = 1
total = N - K
for i in range(len(numbers)):
    while result:
        if length + N - i > total and numbers[i] > result[-1]:
            length -= 1
            result.pop()
            if length == 0:
                result.append(numbers[i])
                length += 1
                break
        else: 
            if length < total:
                result.append(numbers[i])
                length += 1
            break
print(int(''.join(map(str, result))))


