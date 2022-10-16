import sys
input = sys.stdin.readline

N, D = map(int, input().split())
graph = [[] for _ in range(D + 1)]
visited = [int(10e9) for i in range(10001)]
for _ in range(N):
    x, y, distance = map(int, input().split())
    if x < D:
        graph[x].append((y, distance))

visited[0] = 0
for i in range(D + 1):
    if i != 0:
        visited[i] = min(visited[i], visited[i - 1] + 1)
    
    for y, distance in graph[i]:
        if y <= D and visited[i] + distance < visited[y]:
            visited[y] = visited[i] + distance
print(visited[D])