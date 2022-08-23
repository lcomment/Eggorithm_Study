import sys
from collections import defaultdict
from collections import deque
input = sys.stdin.readline
colors = defaultdict(list)
colors['R'], colors['G'], colors['B'], colors['P'], colors['Y']
arr = [list(input().rstrip()) for _ in range(12)]
#상,하,좌,우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
answer = 0
def bfs(visited, i, j):
    cnt = 1
    color = arr[i][j]
    colors[color].append((i, j))
    deq = deque([(i, j)])
    while deq:
        x, y = deq.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= 12 or ny < 0 or ny >= 6 or visited[nx][ny]:
                continue
            if arr[nx][ny] == color:
                cnt += 1
                visited[nx][ny] = 1
                colors[color].append((nx, ny))
                deq.append((nx, ny))
    if cnt < 4:
        for _ in range(cnt):
            colors[color].pop()
    return cnt


def swap():
    for i in range(6):
        for j in range(11, -1, -1):
            check = False
            for k in range(j - 1, -1, -1):
                if arr[k][i] != '.' and arr[j][i] == '.':
                    arr[j][i], arr[k][i] = arr[k][i], arr[j][i]
                    check = True
                    break
            if not check:
                break


while True:
    visited = [[0] * 6 for _ in range(12)]
    check = 0
    for i in range(11, -1, -1):
        for j in range(6):
            if arr[i][j] == '.':
                continue
            else:
                if not visited[i][j]:
                    visited[i][j] = 1
                    if bfs(visited, i, j) >= 4:
                        check += 1
    if check == 0:
        break
    else:
        #연쇄작업 swap 함수
        for key in colors.keys():
            for x, y in colors[key]:
                arr[x][y] = '.'
            colors[key] = []
        answer += 1
        swap()
print(answer)