import sys
R, C, T = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(R)]

up = -1
down = -1
for i in range(R):
    if graph[i][0] == -1:
        up = i
        down = i + 1
        break


def checkSuperDust(graph):
    visited = [[False] * C for i in range(R)]
    for i in range(R):
        for j in range(C):
            if graph[i][j] >= 1:  # 먼지가 존재한다면
                visited[i][j] = graph[i][j]
    return visited


def diffusion(visited, graph):
    # 상,하,좌,우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(R):
        for j in range(C):
            if visited[i][j] is not False:  # 미세먼지가 존재한 위치라면
                extra = visited[i][j] // 5
                cnt = 0
                for k in range(4):
                    x = i + dx[k]
                    y = j + dy[k]
                    # 좌표 벗어나거나 움직인 좌표가 공기청정기의 위치라면
                    if x < 0 or x >= R or y < 0 or y >= C or graph[x][y] == -1:
                        continue
                    graph[x][y] += extra
                    cnt += 1
                graph[i][j] -= (extra * cnt)
    return graph


def rotation_up():
    #오른쪽, 위, 왼, 아래
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = up, 1
    while True:
        nx = x + dx[direct]
        ny = y + dy[direct]
        if x == up and y == 0:
            break
        if nx < 0 or nx >= R or ny < 0 or ny >= C:
            direct += 1
            continue
        graph[x][y], before = before, graph[x][y]
        x = nx
        y = ny


def rotation_down():
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = down, 1
    while True:
        nx = x + dx[direct]
        ny = y + dy[direct]
        if x == down and y == 0:
            break
        if nx < 0 or nx >= R or ny < 0 or ny >= C:
            direct += 1
            continue
        graph[x][y], before = before, graph[x][y]
        x = nx
        y = ny


for _ in range(T):
    visited = checkSuperDust(graph)  # 미세먼지 위치 파악
    graph = diffusion(visited, graph)  # 확산
    rotation_up()
    rotation_down()

cnt = 0
for i in range(len(graph)):
    for j in range(len(graph[i])):
        if graph[i][j] > 0:
            cnt += graph[i][j]

print(cnt)
