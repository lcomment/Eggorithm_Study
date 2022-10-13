import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
graph = []
N, M = map(int, input().split())
visited = [[[0 for _ in range(64)] for _ in range(M)] for _ in range(N)]
start_x, start_y, answer  = 0, 0, sys.maxsize
dx = [-1 ,1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(N):
    graph.append(list(input().rstrip()))


def dfs(start_x, start_y, key):
    global N, M, answer
    for i in range(4):
            nx, ny = start_x + dx[i], start_y + dy[i]
            #좌표 벗어날시 예외
            if nx < 0 or nx >= N or ny < 0 or ny >= M or graph[nx][ny] == '#':
                continue
            #빈칸일 때
            if graph[nx][ny] == '.' or graph[nx][ny] == '0':
                if not visited[nx][ny][key]:
                    visited[nx][ny][key] = visited[start_x][start_y][key] + 1
                    dfs(nx, ny, key)
            #열쇠 방
            elif graph[nx][ny].islower():
                if not visited[nx][ny][key]:
                    new_key = key | (1<<ord(graph[nx][ny]) - ord('a'))
                    visited[nx][ny][new_key] = visited[start_x][start_y][key] + 1
                    dfs(nx, ny, new_key)
            #문 방
            elif graph[nx][ny].isupper():
                if not visited[nx][ny][key]:
                    if key & (1 << ord(graph[nx][ny]) - ord('A')):
                        visited[nx][ny][key] = visited[start_x][start_y][key] + 1
                        dfs(nx, ny, key)
            elif graph[nx][ny] == '1':
                answer = min(answer, visited[start_x][start_y][key])
    return answer


#시작 좌표 찾기
for i in range(N):
    isFind = False
    for j in range(M):
        if graph[i][j] == '0':
            start_x, start_y = i, j
            visited[start_x][start_y][0] = 1
            isFind = True
            break
    if isFind:
        break
if dfs(start_x, start_y, 0) == sys.maxsize:
    print(-1)
else:
    print(answer)

