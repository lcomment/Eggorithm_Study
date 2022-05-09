import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
# 상,하,좌,우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


# 바같을 전부 -1로 변경
def outside():
    deq = deque([(0, 0)])
    visited = [[False] * M for _ in range(N)]
    visited[0][0] = True
    graph[0][0] = -1
    while deq:
        x, y = deq.popleft()
        for i in range(4):
            x_ = x + dx[i]
            y_ = y + dy[i]
            if x_ < 0 or x_ >= N or y_ < 0 or y_ >= M:
                continue
            if graph[x_][y_] == 0 or graph[x_][y_] == -1:
                if not visited[x_][y_]:
                    deq.append((x_, y_))
                    graph[x_][y_] = -1
                    visited[x_][y_] = True

# 다 녹았는지 체크


def meltAll():
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                return False
    return True


answer = 0
while not meltAll():
    outside()
    check = []
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:  # 치즈라면
                cnt = 0
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if nx < 0 or nx >= N or ny < 0 or ny >= M:
                        continue
                    if graph[nx][ny] == -1:  # 밖이라면
                        cnt += 1

                if cnt >= 2:  # 접촉 면적이 두 개 이상이라면
                    check.append((i, j))
    for x, y in check:
        graph[x][y] = 0
    answer += 1

print(answer)
