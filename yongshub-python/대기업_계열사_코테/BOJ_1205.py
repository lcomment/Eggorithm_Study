import sys
from collections import deque
input = sys.stdin.readline

n, score, p = map(int, input().split())
stack = []
if n == 0:
    print(1)
else:
    deq = deque(sorted(list(map(int, input().split())), reverse=True))
    length = 1
    while deq:
        stack.append(deq.popleft())
        if score <= stack[-1]:
            length += 1
        else:
            break
    if length > p:
        print(-1)
    else:
        for i in range(length - 1):
            if stack[i] == score:
                length = i + 1
                break
        print(length)