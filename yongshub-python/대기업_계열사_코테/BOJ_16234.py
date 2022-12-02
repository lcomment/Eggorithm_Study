# N * N 의 땅, r행 c열 -> A[r][c] 명이 살고 있다.
#국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
import sys
from collections import deque
input = sys.stdin.readline

N, L, R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

#상,하,좌,우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
cnt = 0
def move_population(country, total_population, positions):
    divide_result = total_population // country
    while positions:
        x, y = positions.popleft()
        graph[x][y] = divide_result


def bfs(x, y):
    global L, R
    visited[x][y] = True # 방문 처리
    deq = deque([(x, y, graph[x][y])])

    country = 1 # 현재 인구 이동 대기 나라 수
    total_population = graph[x][y] # 통합 인구 수
    positions= deque([(x, y)])
    while deq:
        x, y, popluation = deq.popleft()
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[nx][ny]:
                continue
            if L <= abs(popluation - graph[nx][ny]) <= R: # 두 나라 인구차이가 L명 이상 R명 이하
                country += 1
                total_population += graph[nx][ny]
                visited[nx][ny] = True
                positions.append((nx, ny))
                deq.append((nx, ny, graph[nx][ny]))
    if country > 1: # 인구 이동 가능하다면
        move_population(country, total_population, positions)
        return True
    return False




while True:
    visited = [[False] * N for _ in range(N)]
    move_check = False
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                if bfs(i, j):
                    move_check = True
    # 조건 -> 만족하지 않는다면
    if move_check:
        cnt += 1
    else:
        break
print(cnt)