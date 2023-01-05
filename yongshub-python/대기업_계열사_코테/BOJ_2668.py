import sys

input = sys.stdin.readline

N = int(input().rstrip())
graph = [0] * (N + 1)
visited = [False] * (N + 1)
answer = []    
for i in range(1, N + 1):
    graph[i] = int(input().rstrip())


def dfs(x, start):
    visited[x] = True
    if x not in nodes:
        nodes.append(x)

    if not visited[graph[x]]:
        if not dfs(graph[x], start):
            visited[x] = False
            return visited[x]
        return True

    if graph[x] == start:
        return True
    visited[x] = False
    return False


for i in range(1, N + 1):
    nodes = []
    if not visited[i]:
        if dfs(i, i):
            answer.extend(nodes)

print(len(answer))
for number in sorted(answer):
    print(number)

