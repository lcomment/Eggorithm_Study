import sys
sys.setrecursionlimit(10 ** 6)

R, C = map(int, sys.stdin.readline().split())
graph = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(R)]

dx = [-1, 0, 1]
dy = [1, 1, 1]


def dfs(x, y):
    if y == C - 1:  # 끝에 도착했다면
        return True
    # 오른쪽 위대각선, 오른쪽, 오른쪽 아래 대각선
    for i in range(3):
        move_x = x + dx[i]
        move_y = y + dy[i]
        # 좌표값 벗어나거나 방문한 노드라면
        if move_x < 0 or move_x >= R or move_y < 0 or move_y >= C or graph[move_x][move_y] == 'x':
            continue
        graph[move_x][move_y] = 'x'
        if dfs(move_x, move_y):  # 방문한 노드가 아니라면
            return True
    return False


# 최대 파이프라인 개수 구하기
cnt = 0
for i in range(R):
    if dfs(i, 0):
        cnt += 1
print(cnt)
