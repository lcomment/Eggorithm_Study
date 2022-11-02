import sys
from collections import deque
input = sys.stdin.readline
# N M 행렬 맵 0은 이동할 수 있는 곳 1은 이동할 수 없는 벽 (1,1) -> (N, M) 위치까지 이동 최단경로 알고리즘 : 가장 적은 개수의 칸을 지나는 경로인데 시작칸과 끝나는 칸도 포함
# ! 만약에 이동하는 도중에 한개의 벽을 부수고 이동하는 것이 경로가 짧아진다면 한 개까지 부수고 이동하는것은 가능

#상,하,좌,우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    #N, M 입력
    N, M = map(int, input().split())
    #행렬
    matrix = [list(map(int, input().rstrip())) for _ in range(N)]
    #방문여부(집합)
    isExist = {(0, 0, False)}
    #BFS를 위한 Queue
    deq = deque([(0, 0, 1, False)]) # x, y, 노드개수, 벽 부순 여부
    answer = int(10e9)
    while deq:
        x, y, cnt, wall = deq.popleft()
        if (x, y) == (N - 1, M - 1):
            answer = min(answer, cnt)
            continue
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #맵을 벗어난다면
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            #벽 부수고 가는 경우
            if matrix[nx][ny] == 1 and wall is False and (nx, ny, True) not in isExist:
                isExist.add((nx, ny, True))
                deq.append((nx, ny, cnt + 1, True))
            #그냥 갈 수 있는 경우
            if matrix[nx][ny] == 0 and (nx, ny, wall) not in isExist:
                isExist.add((nx, ny, wall))
                deq.append((nx, ny, cnt + 1, wall))
    print(-1) if answer == int(10e9) else print(answer)

bfs()