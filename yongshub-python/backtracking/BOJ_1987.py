import sys

n, m = map(int, sys.stdin.readline().split())
graph = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
visited = [False] * 101
# 상,하,좌,우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
# 결과값
result = 0
# 방문 노드 개수
cnt = 0
# 알파벳 별로 defaultdict로 방문노드 생성
for i in range(n):
    for j in range(m):
        visited[ord(graph[i][j])] = False


def dfs(x, y, cnt):
    global result
    visited[ord(graph[x][y])] = True
    cnt += 1
    # 상,하,좌,우
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        # 좌표 값 벗어난다면
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue

        if visited[ord(graph[nx][ny])] is False:  # 첫 방문 노드라면
            dfs(nx, ny, cnt)
            visited[ord(graph[nx][ny])] = False
    if cnt > result:
        result = cnt


dfs(0, 0, cnt)
print(result)
