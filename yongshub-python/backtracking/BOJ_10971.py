import sys
input = sys.stdin.readline

N = int(input().rstrip())
graph = [list(map(int, input().split())) for _ in range(N)]
minValue = sys.maxsize


def backTracking(start, next, value, visited):
    global minValue

    if len(visited) == N:  # 방문한 도시가 N개일 시
        if graph[next][start] != 0:  # 0일 시 X
            minValue = min(minValue, value + graph[next][start])
        return

    for i in range(N):  # 1 ~ N개의 도시 확인
        if graph[next][i] != 0 and i not in visited and value < minValue:
            visited.append(i)
            backTracking(start, i, value + graph[next][i], visited)
            visited.pop()


for i in range(N):
    backTracking(i, i, 0, [i])

print(minValue)
