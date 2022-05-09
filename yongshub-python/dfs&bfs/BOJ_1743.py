import sys
from collections import deque

N, M, K = map(int, sys.stdin.readline().split())
locations = [[True] * M for _ in range(N)]
trashes = []

for _ in range(K):
    x, y = map(int, sys.stdin.readline().split())
    locations[x - 1][y - 1] = False


def bfs(start, end):
    count = 1
    deq = deque([(start, end)])
    # 상,하,좌,우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while deq:
        x, y = deq.popleft()
        locations[x][y] = True  # 방문한 곳으로 변경
        for i in range(4):
            move_x = x + dx[i]
            move_y = y + dy[i]
            # 좌표값 벗어난다면
            if move_x < 0 or move_x >= N or move_y < 0 or move_y >= M:
                continue
            else:
                if locations[move_x][move_y] == False:  # 쓰레기라면
                    locations[move_x][move_y] = True
                    deq.append((move_x, move_y))
                    count += 1
    return count


count = 0
for i in range(N):
    for j in range(M):
        if locations[i][j] == False:
            result = bfs(i, j)
            count = max(count, result)

print(count)
