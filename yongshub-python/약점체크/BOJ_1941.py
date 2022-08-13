import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

graph = []
cases = []
for i in range(5):
    graph.append(list(input().rstrip()))
    cases.append((i, 0))
    cases.append((i, 1))
    cases.append((i, 2))
    cases.append((i, 3))
    cases.append((i, 4))

count = 0
for case in combinations(cases, 7):
    dasom_team = 0
    case = list(case)
    (x_1, y_1), (x_2, y_2), (x_3, y_3), (x_4, y_4), (x_5, y_5), (x_6, y_6), (x_7, y_7) = case[0], case[1], case[2], case[3], case[4], case[5], case[6]
    if graph[x_1][y_1] == 'S':
        dasom_team += 1
    if graph[x_2][y_2] == 'S':
        dasom_team += 1
    if graph[x_3][y_3] == 'S':
        dasom_team += 1
    if graph[x_4][y_4] == 'S':
        dasom_team += 1
    if graph[x_5][y_5] == 'S':
        dasom_team += 1
    if graph[x_6][y_6] == 'S':
        dasom_team += 1
    if graph[x_7][y_7] == 'S':
        dasom_team += 1

    if dasom_team >= 4:
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]
        visited = dict()
        visited[(x_1, y_1)] = 1
        visited[(x_2, y_2)] = 0
        visited[(x_3, y_3)] = 0
        visited[(x_4, y_4)] = 0
        visited[(x_5, y_5)] = 0
        visited[(x_6, y_6)] = 0
        visited[(x_7, y_7)] = 0
        deq = deque([(x_1, y_1)])
        cnt = 1
        while deq:
            x, y = deq.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                try:
                    if not visited[(nx, ny)]:
                        visited[(nx, ny)] = 1
                        deq.append((nx, ny))
                        cnt += 1
                except:
                    continue
        if cnt == 7:
            count += 1
print(count)