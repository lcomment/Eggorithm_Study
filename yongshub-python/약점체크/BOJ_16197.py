import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
graph = []
coins = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(N):
    graph.append(list(input().rstrip()))
#두 동전 위치 찾기
for i in range(N):
    for j in range(M):
        if graph[i][j] == 'o':
            coins.append((i, j))

deq = deque([(coins[0][0], coins[0][1], coins[1][0], coins[1][1], 0)])
while deq:
    x_1, y_1, x_2, y_2, cnt = deq.popleft()
    if cnt >= 10:
        print(-1)
        exit()
    for i in range(4):
        nx_1, ny_1 = x_1 + dx[i], y_1 + dy[i]
        nx_2, ny_2 = x_2 + dx[i], y_2 + dy[i]
        if 0 <= nx_1 < N and 0 <= ny_1 < M and 0 <= nx_2 < N and 0 <= ny_2 < M:
            if graph[nx_1][ny_1] == '#': #벽이라면
                nx_1, ny_1 = x_1, y_1
            if graph[nx_2][ny_2] == '#':
                nx_2, ny_2 = x_2, y_2
            deq.append((nx_1, ny_1, nx_2, ny_2, cnt + 1))
        elif 0 <= nx_1 < N and 0 <= ny_1 < M: # 동전2가 떨어진 경우
            print(cnt + 1)
            exit()
        elif 0 <= nx_2 < N and 0 <= ny_2 < M:
            print(cnt + 1)
            exit()