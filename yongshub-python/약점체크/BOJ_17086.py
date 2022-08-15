import sys
from collections import defaultdict
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split()) # 2<=N,M<=50
graph = [[0] * M for _ in range(N)]
sharks = defaultdict(int)
visited = [[int(1e9)] * M for _ in range(N)]
answer = 0
#상, 하, 좌, 우 , 왼쪽 위 대각선, 오른쪽 위 대각선, 왼쪽 아래 대각선, 오른쪽 아래 대각선
dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]
for i in range(N):
    colums = list(map(int, input().split()))
    for j in range(M):
        graph[i][j] = colums[j]
        if graph[i][j] == 1:
            visited[i][j] = 1
            sharks[(i, j)]

def bfs(x, y):
    deq = deque([(x, y, 0)])

    while deq:
        # x좌표, y좌표, 거리
        x, y, vector = deq.popleft()
        vector += 1

        for i in range(8):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M or vector >= visited[nx][ny]:
                continue
            visited[nx][ny] = vector
            deq.append((nx, ny, vector))


for x, y in sharks.keys():
    bfs(x, y)

for i in range(N):
    for j in range(M):
        answer = max(answer, visited[i][j])
print(answer)