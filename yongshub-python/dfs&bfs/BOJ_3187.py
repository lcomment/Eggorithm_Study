import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().split())
maps = [list(input()[0:C]) for _ in range(R)]
visited = [[False] * C for _ in range(R)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = [0, 0]


def bfs(i, j):
    vCount = 0
    kCount = 0
    deq = deque()
    visited[i][j] = True

    deq.append((i, j))

    while deq:
        x, y = deq.popleft()

        if maps[x][y] == 'v':
            vCount += 1
        elif maps[x][y] == 'k':
            kCount += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= R or ny < 0 or ny >= C or visited[nx][ny] or maps[nx][ny] == '#':
                continue
            else:
                visited[nx][ny] = True
                deq.append((nx, ny))
    if vCount >= kCount:
        result[1] += vCount
    else:
        result[0] += kCount


for i in range(R):
    for j in range(C):
        if maps[i][j] == '#' or visited[i][j]:
            continue
        else:
            bfs(i, j)
print(*result)
