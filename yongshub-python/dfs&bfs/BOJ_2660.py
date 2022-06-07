from collections import defaultdict
from collections import deque
import sys
input = sys.stdin.readline

N = int(input().rstrip())
graph = defaultdict(list)
answer = []
score = 10 ** 9

while True:  # 입력 받기
    x, y = map(int, input().split())
    if x == -1 and y == -1:
        break
    graph[x].append(y)
    graph[y].append(x)


def bfs(deq):
    cnt = 0
    visited = [0] * (N + 1)
    while deq:
        start = deq.popleft()

        for i in graph[start]:
            if not visited[i]:  # 아직 방문하지 않았다면
                visited[i] = visited[start] + 1
                deq.append(i)
    return visited


for start in range(1, N + 1):
    deq = deque()
    deq.append(start)
    result = bfs(deq)
    cnt = 0
    for i in range(N + 1):
        if i == start:  # start의 node를 방문기록이 남지 않아서 추가되었을 수 있기 때문에
            continue
        cnt = max(cnt, result[i])

    if cnt < score:
        score = cnt
        answer = []
        answer.append(start)
    elif cnt == score:
        answer.append(start)

print(score, len(answer))
print(*answer)
