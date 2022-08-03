import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)] # 그래프
degree = [0 for _ in range(N + 1)] # 진입 
deq = deque([])
graph = deque(graph)
result = []
for _ in range(M):
    a, b = map(int, input().split())
    degree[b] += 1 # 진입 차수 증가
    graph[a].append(b) # a와 연결된 정점


for i in range(1, N + 1):
    if degree[i] == 0:
        deq.append(i)

while deq:
    head = deq.popleft()
    result.append(head)
    for i in graph[head]:
        if degree[i] > 0:
            degree[i] -= 1
            if degree[i] == 0:
                deq.append(i)
print(*result)