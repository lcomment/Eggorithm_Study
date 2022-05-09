from collections import deque

a, b, c = map(int, input().split())

# 경우의 수를 담을 큐
q = deque()
q.append((0, 0))

# 방문 여부 저장
visited = [[False] * (b + 1) for _ in range(a + 1)]
visited[0][0] = True

answer = []


def pour(x, y):
    if not visited[x][y]:
        visited[x][y] = True
        q.append((x, y))


def bfs():
    while q:
        # A물통에 있는 물: x, B물통에 있는 물: y, C물통에 있는 물: z
        x, y = q.popleft()
        z = c - x - y # c용기에서 A에 담긴 용량, B에 담긴 용량을 빼서 z는 C의 현재 용량

        # A 물통이 비어있는 경우에 C 물통에 남아있는 양 저장
        if x == 0:
            answer.append(z)

        # A에서 B로 물 이동
        water = min(x, b - y)
        pour(x - water, y + water)
        # A에서 C로 물 이동
        water = min(x, c - z)
        pour(x - water, y)

        # B에서 C로 물 이동
        water = min(y, c - z)
        pour(x, y - water)
        # B에서 A로 물 이동
        water = min(y, a - x)
        pour(x + water, y - water)

        # C에서 A로 물 이동
        water = min(z, a - x)
        pour(x + water, y)
        # C에서 B로 물 이동
        water = min(z, b - y)
        pour(x, y + water)


bfs()

answer.sort()
print(*answer)
