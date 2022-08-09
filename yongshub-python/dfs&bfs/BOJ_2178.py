import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
graph = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[N * M] * M for _ in range(N)]
for _ in range(N):
    graph.append(list(map(int, input().rstrip())))


def bfs():
    global N, M
    deq = deque([(0, 0)])
    visited[0][0] = 1
    while deq:
        x, y = deq.popleft()
        if x == N - 1 and y == M - 1:
            break
        else: cnt = visited[x][y]

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M or graph[nx][ny] == 0:
                continue
            
            if cnt + 1 < visited[nx][ny]:
                visited[nx][ny] = cnt + 1
                deq.append((nx, ny))

bfs()
print(visited[N - 1][M - 1])