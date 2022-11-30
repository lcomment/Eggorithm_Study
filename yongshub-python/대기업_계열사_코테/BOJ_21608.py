import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input().rstrip())
graph = [[0] * N for _ in range(N)]
visited = [False] * ((N ** 2) + 1)
check_scores = defaultdict(list)
scores = dict()
total_score = 0
scores[0], scores[1], scores[2], scores[3], scores[4] = 0, 1, 10, 100, 1000

#상,하,좌,우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def isExistLikeFriends(likeFriends):
    for number in likeFriends:
        if visited[number]:
            return True
    return False


def getMaxLocation(likeFriends, i, j):
    global N
    cnt = 0

    for k in range(4):
        nx, ny = i + dx[k], j + dy[k]
        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            continue
        if graph[nx][ny] in likeFriends:
            cnt += 1
    return cnt


def getLocation(likeFriends):
    max_cnt = 0
    locations = [(0, 0)]
    
    for i in range(len(graph)):
        for j in range(len(graph)):
            if graph[i][j]:
                continue
            max_value = getMaxLocation(likeFriends, i, j)
            if max_value > max_cnt:
                locations = [(i, j)]
                max_cnt = max_value
            elif max_value == max_cnt:
                locations.append((i, j))
    return locations


def getMaxEmptyBlanksLocation(locations):
    global N
    max_cnt = 0
    max_x, max_y = -1, -1
    for (x, y) in locations:
        cnt = 0
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            elif graph[nx][ny] == 0:
                cnt += 1
        if cnt > max_cnt:
            max_x, max_y = x, y
            max_cnt = cnt
    return max_x, max_y


def makeGraphTuple(graph):
    new_graph = []
    for i in range(len(graph)):
        for j in range(len(graph)):
            if graph[i][j] == 0:
                new_graph.append((i, j))
    return new_graph


for _ in range(N ** 2):
    case = list(map(int, input().split()))
    number = case[0]
    check_scores[number] = case[1:]
    if isExistLikeFriends(check_scores[number]):
        #인접한 칸 중에 가장 많은 칸 구하기
        locations = getLocation(check_scores[number])
        if len(locations) > 1: # 조건 1을 만족하는 칸이 여러개라면 비어있는 칸이 가장 많은 칸
            x, y = getMaxEmptyBlanksLocation(locations)
            graph[x][y] = number
        else:
            graph[locations[0][0]][locations[0][1]] = number
        visited[number] = True
    else:
        #그래프가 비어있을 때
        x, y = getMaxEmptyBlanksLocation(makeGraphTuple(graph))
        if x != -1 and y != -1:
            graph[x][y] = number
            visited[number] = True
print(graph)

for i in range(N):
    for j in range(N):
        cnt = 0
        for k in range(4):
            nx, ny = i + dx[k], j + dy[k]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if graph[nx][ny] in check_scores[graph[i][j]]:
                cnt += 1
        total_score += scores[cnt]

print(total_score)