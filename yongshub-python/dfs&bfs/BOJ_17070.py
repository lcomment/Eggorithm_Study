import sys
input = sys.stdin.readline

N = int(input().rstrip())
visited = [[0] * N for _ in range(N)]
house = [list(map(int, input().split())) for _ in range(N)]


def move_y(dx, dy):
    if dy + 1 >= N or house[dx][dy + 1]:
        return False
    else:
        return True


def move_x(dx, dy):
    if dx + 1 >= N or house[dx + 1][dy]:
        return False
    else:
        return True


def move_cross(dx, dy):
    if dx + 1 >= N or dy + 1 >= N or house[dx + 1][dy] or house[dx][dy + 1] or house[dx + 1][dy + 1]:
        return False
    else:
        return True


def dfs(x, y, dx, dy):
    nx = dx - x
    ny = dy - y

    visited[dx][dy] += 1

    if dx == N - 1 and dy == N - 1:
        return

    if nx == 0 and ny == 1:
        if move_y(dx, dy):
            dfs(dx, dy, dx, dy + 1)
        if move_cross(dx, dy):
            dfs(dx, dy, dx + 1, dy + 1)
    elif nx == 1 and ny == 0:
        if move_x(dx, dy):
            dfs(dx, dy, dx + 1, dy)
        if move_cross(dx, dy):
            dfs(dx, dy, dx + 1, dy + 1)
    else:
        if move_y(dx, dy):
            dfs(dx, dy, dx, dy + 1)
        if move_x(dx, dy):
            dfs(dx, dy, dx + 1, dy)
        if move_cross(dx, dy):
            dfs(dx, dy, dx + 1, dy + 1)


if house[N - 1][N - 1] == 1:
    print(0)
else:
    dfs(0, 0, 0, 1)
    print(visited[N - 1][N - 1])
