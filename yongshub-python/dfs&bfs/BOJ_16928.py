import sys
from collections import deque


input = sys.stdin.readline
# 사다리의 수, 뱀의 수
N, M = map(int, input().split())
graph = [0] * 101
visited = [0] * 101
for _ in range(N):
    x, y = map(int, input().split())
    graph[x] = y

for _ in range(M):
    x, y = map(int, input().split())
    graph[x] = y


def bfs():
    deq = deque([1])
    count = 0
    while deq:
        x = deq.popleft()
        if x >= 100:
            return

        for i in range(1, 7):
            if x + i <= 100 and graph[x + i]:
                if visited[x + i] and visited[x + i] >= count:
                    visited[x + i] = count + 1
                    deq.append(graph[x + i])
            else:
                if x + i <= 100:
                    if visited[x + i] >= count:
                        visited[x + i] = count + 1
                        deq.append(x + i)
        count += 1


bfs()
print(visited[100])
