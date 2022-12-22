import sys
from collections import deque
input = sys.stdin.readline

# 입력 예시 EX) 1 2 3 4 -> 1번 카드가 제일 위에 4번 카드가 제일 아래에 있다.

N = int(input().rstrip())
deq = deque([i for i in range(1, N + 1)])

while deq:
    if len(deq) == 1:
        break
    deq.popleft()
    deq.append(deq.popleft())
print(*deq)