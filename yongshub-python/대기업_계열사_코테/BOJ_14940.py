import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
answer = [[0] * m for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[int(10e9)] * m for _ in range(n)]

def bfs():
    global n, m

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                start_x, start_y = i, j
                break
            
    visited[start_x][start_y] = 0 # 방문
    deq = deque([(start_x, start_y)])
    while deq:
        x, y = deq.popleft()
            
        for k in range(4):
            nx, ny = dx[k] + x, dy[k] + y
            if nx < 0 or nx >= n or ny < 0 or ny >= m or graph[nx][ny] == 0:
                continue
            distance = visited[x][y] + 1
            if distance < visited[nx][ny]:
                deq.append((nx, ny))
                visited[nx][ny] = distance


bfs()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            visited[i][j] = 0
        if visited[i][j] == int(10e9):
            visited[i][j] = -1
for i in range(n):
    print(*visited[i])