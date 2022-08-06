import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 9)

N = int(input().rstrip())
graph = [list(map(int, input().rstrip())) for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = []
cnt = 0

def dfs(x, y):
    cnt = 1
    graph[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or ny < 0 or nx >= N or ny >= N:
            continue
        if graph[nx][ny]:
            cnt += dfs(nx, ny)
    return cnt


for i in range(N):
    for j in range(N):
        if graph[i][j]:
            cnt += 1
            result.append(dfs(i, j))

print(cnt)
result.sort()
for count in result:
    print(count)