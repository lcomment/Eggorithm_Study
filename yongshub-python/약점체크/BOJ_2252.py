import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())

numbers = [i for i in range(1, N + 1)]
compare = []
deq = deque(numbers)

for _ in range(M):
    x, y = map(int, input().split())
    idx_1, idx_2 = deq.index(x), deq.index(y)
    if idx_1 > idx_2:
        deq.remove(x)
        deq.appendleft(x)

print(*deq)

#시간 초과난다.