import sys
from collections import deque
from collections import defaultdict
input = sys.stdin.readline
graph = []
N, M = map(int, input().split())
visited = [[int(10e9)] * M] * N
keys = defaultdict(bool)
start_x, start_y, answer  = 0, 0, sys.maxsize
dx = [-1 ,1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(N):
    graph.append(list(input().rstrip()))

for alphabet in ['a', 'b', 'c', 'd', 'e' ,'f']:
    keys[alphabet]

def dfs(start_x, start_y, keys):
    global N, M, answer
    #deq = deque([(start_x, start_y)])
    isEscape = False
    for i in range(4):
            nx, ny = start_x + dx[i], start_y + dy[i]
            #좌표 벗어날시 예외
            if nx < 0 or nx >= N or ny < 0 or ny >= M or graph[nx][ny] == '#':
                continue
            #빈칸일 때
            if graph[nx][ny] == '.':
                if visited[start_x][start_y] + 1 < visited[nx][ny]:
                    visited[nx][ny] = visited[start_x][start_y] + 1
                    answer = min(answer, dfs(nx, ny, keys))
            #열쇠 방
            elif graph[nx][ny].islower():
                if visited[start_x][start_y] + 1 < visited[nx][ny]:
                    visited[nx][ny] = visited[start_x][start_y] + 1
                    keys[graph[nx][ny]] = True
                    answer = min(answer, dfs(nx, ny, keys))
                    keys[graph[nx][ny]] = False
            #처음 위치
            elif graph[nx][ny] == '0':
                if visited[nx][ny] == 0:
                    visited[nx][ny] = visited[start_x][start_y] + 1
                    answer = min(answer, dfs(nx, ny, keys))
                elif visited[start_x][start_y] + 1 < visited[nx][ny]:
                    visited[nx][ny] = visited[start_x][start_y] + 1
                    answer = min(answer, dfs(nx, ny, keys))
            #문 방
            elif graph[nx][ny].isupper():
                if keys[graph[nx][ny].lower()] is True and visited[start_x][start_y] + 1 < visited[nx][ny]:
                    visited[nx][ny] = visited[start_x][start_y] + 1
                    answer = min(answer, dfs(nx, ny, keys))
            else:
                isEscape = True
                answer = min(answer, visited[start_x][start_y] + 1)
                return answer
    return answer




#시작 좌표 찾기
for i in range(N):
    isFind = False
    for j in range(M):
        if graph[i][j] == '0':
            start_x, start_y = i, j
            visited[start_x][start_y] = 0 # 방문 처리
            isFind = True
            break
    if isFind:
        break
if dfs(start_x, start_y, keys) == sys.maxsize:
    print(-1)
else:
    print(answer)


