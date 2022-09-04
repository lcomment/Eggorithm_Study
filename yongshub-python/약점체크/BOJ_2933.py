import sys
sys.setrecursionlimit(10 ** 9)
from collections import deque

input = sys.stdin.readline
# 좌, 상, 우, 하
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]
R, C = map(int, input().split())
cave = [list(input().rstrip()) for _ in range(R)]
N = int(input().rstrip())
height = list(map(lambda x: R - int(x), input().split()))
# 방문 노드 확인
visited = [[0] * C for _ in range(R)]


def bfs(nx, ny, R, C):
    maxRow = 0
    deq = deque([(nx, ny)])
    while deq:
        x, y = deq.popleft()
        visited[x][y] = 1
        maxRow = max(maxRow, x)
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= R or ny < 0 or ny >= C or visited[nx][ny] or cave[nx][ny] == '.':
                continue
            else:
                deq.append((nx, ny))
    return maxRow


def maxCheck(row, R, C):
    maxCnt = 100
    for idx, value in enumerate(visited[row]):
        if value == 0:
            continue
        cnt = 0
        for j in range(row + 1, R):
            if cave[j][idx] == 'x':
                break
            cnt += 1
            if 0 <= idx - 1 < C and cave[j][idx - 1] == 'x':
                break
            if 0 <= idx + 1 < C and cave[j][idx + 1] == 'x':
                break
        maxCnt = min(maxCnt, cnt)
    return maxCnt


def topDown(maxRow,R, C):
    maxCnt = maxCheck(maxRow, R, C)
    if maxCnt != 0:
        for i in range(maxRow, -1, -1):
            for j in range(C):
                if visited[i][j] == 1:
                    visited[i][j] = 0
                    cave[i][j] = '.'
                    cave[i + maxCnt][j] = 'x'


for i in range(N):
    x, y = (-1, -1)
    # 짝수일때는 왼쪽에서 막대 이동
    if i % 2 == 0:
        for idx in range(C):
            if cave[height[i]][idx] == 'x':
                # empty로 변경 현재 좌표값 입력
                cave[height[i]][idx] = '.'
                x, y = height[i], idx
                break
    # 홀수라면 오른쪽에서 막대 이동
    else:
        for idx in range(C - 1, -1, -1):
            if cave[height[i]][idx] == 'x':
                # empty로 변경 현재 좌표값 입력
                cave[height[i]][idx] = '.'
                x, y = height[i], idx
                break
    if x == -1 and y == -1:
        continue
    # 방문 노드 통해서 상,하,좌,우
    else:
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= R or ny < 0 or ny >= C or visited[nx][ny] or cave[nx][ny] == '.':
                continue
            else:
                maxRow = bfs(nx, ny, R, C)
                if maxRow != R - 1:  # 내려줘야하는 작업이 필요하다면
                    topDown(maxRow, R, C)
                else:
                    for i in range(R):
                        for j in range(C):
                            if visited[i][j]:
                                visited[i][j] = 0
for i in range(R):
    print(''.join(cave[i]))