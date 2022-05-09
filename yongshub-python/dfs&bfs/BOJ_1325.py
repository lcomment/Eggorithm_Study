import sys
from collections import deque
# 메모리 초과에 대한 이슈를 해결하는데 오래걸렸다 -> 방문기록을 남기자
N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[B].append(A)


def bfs(key):
    deq = deque()
    deq.append(key)
    count = 1
    visited = [False] * (N + 1)
    visited[key] = True
    while deq:
        number = deq.popleft()
        for num in graph[number]:
            if not visited[num]:
                visited[num] = True
                deq.append(num)
                count += 1
    return count


result = 0
visited = [0] * (N + 1)
for key in range(1, N + 1):
    if len(graph[key]) >= 1:
        count = bfs(key)
        visited[key] = count

maxCount = max(visited)
for i in range(len(visited)):
    if visited[i] == maxCount:
        print(i, end=' ')
