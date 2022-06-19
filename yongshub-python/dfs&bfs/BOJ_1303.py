import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())  # N, M
battleGround = []
visited = []
for _ in range(M):
    battleGround.append(list(input().rstrip()))
    visited.append([False] * N)

#상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
deq = deque()
white = 0
blue = 0


def bfs(a, b, color):
    deq.append((a, b))
    visited[a][b] = True  # 방문 기록
    cnt = 1  # 큐에 추가된 개수
    while deq:
        x, y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= M or ny < 0 or ny >= N or visited[nx][ny] is True:
                continue
            if battleGround[nx][ny] == color and visited[nx][ny] is False:
                deq.append((nx, ny))
                visited[nx][ny] = True
                cnt += 1
    return cnt ** 2


for i in range(M):
    for j in range(N):
        if visited[i][j] is False and battleGround[i][j] == 'W':  # white인 경우
            white += bfs(i, j, 'W')
        elif visited[i][j] is False and battleGround[i][j] == 'B':  # bluew인 경우
            blue += bfs(i, j, 'B')

print(white, blue)
