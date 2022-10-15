import sys
input = sys.stdin.readline
import heapq as heap

#상,하,좌,우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def dijkstra(N):
    visited = [[int(10e9)] * N for _ in range(N)]
    start_x, start_y = 0, 0
    visited[start_x][start_y] = graph[start_x][start_y]
    nodes = []
    heap.heapify(nodes)
    for i in range(4):
        nx, ny = start_x + dx[i], start_y + dy[i]
        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            continue
        visited[nx][ny] = visited[start_x][start_y] + graph[nx][ny]
        heap.heappush(nodes, (visited[nx][ny], nx, ny))
    
    while nodes:
        cost, x, y = heap.heappop(nodes)
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            next = cost + graph[nx][ny]
            if next < visited[nx][ny]:
                visited[nx][ny] = next
                heap.heappush(nodes, (visited[nx][ny], nx, ny))
    return visited[N - 1][N - 1]
    

start = 1
while True:
    N = int(input().rstrip())
    if N == 0:
        break
    else:
        graph = []
        for i in range(N):
            graph.append(list(map(int, input().split())))
        minValue = dijkstra(N)
        print(f'Problem {start}: {minValue}')
        start += 1