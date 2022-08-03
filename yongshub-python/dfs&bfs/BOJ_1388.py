import sys
input = sys.stdin.readline
from collections import deque
N, M = map(int, input().split())

graph = [list(input().rstrip()) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
count = 0

def bfs(x, y):
    global count
    deq = deque([(x, y)])
    value = None
    if graph[x][y] == '-':
        value = '-'
        idx = (2, 4)
    else:
        value = '|'
        idx = (0, 2)
    while deq:
        x, y= deq.popleft()
        visited[x][y] = True    
        for i in range(idx[0], idx[1]):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M or visited[nx][ny]:
                continue
            if graph[nx][ny] == value:
                deq.append((nx, ny))
    count += 1


for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            bfs(i, j)
print(count)
