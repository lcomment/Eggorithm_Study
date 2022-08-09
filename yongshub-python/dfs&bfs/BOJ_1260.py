import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited_dfs = [False] * (N + 1)
visited_bfs = [False] * (N + 1)
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N + 1):
    graph[i].sort() # 오름차순 정렬

def dfs(start):
    if not visited_dfs[start]:
        visited_dfs[start] = True
        print(start, end=' ')
    
    for node in graph[start]:
        if not visited_dfs[node]:
            dfs(node)


def bfs(start):
    if not visited_bfs[start]:
        visited_bfs[start] = True
    
    deq = deque([start])
    while deq:
        node = deq.popleft()
        print(node, end=' ')
        for n in graph[node]:
            if not visited_bfs[n]:
                visited_bfs[n] = True
                deq.append(n)
    print()

dfs(V)
print()
bfs(V)