import sys

input = sys.stdin.readline

N = int(input().rstrip())
graph = [list(map(int, input().split())) for _ in range(N)]
answer = 0
def move(graph, direction):
    global N
    if direction == 0: #동쪽
        for i in range(N):
            top = N - 1
            for j in range(N - 2, -1, -1):
                if graph[i][j]:
                    value = graph[i][j]
                    graph[i][j] = 0
                    if graph[i][top] == value:
                        graph[i][top] = value * 2
                        top -= 1
                    elif graph[i][top] == 0:
                        graph[i][top] = value
                    else:
                        top -= 1
                        graph[i][top] = value
    elif direction == 1: #서쪽
        for i in range(N):
            top = 0
            for j in range(1, N):
                if graph[i][j]:
                    value = graph[i][j]
                    graph[i][j] = 0
                    if graph[i][top] == value:
                        graph[i][top] = value * 2
                        top += 1
                    elif graph[i][top] == 0:
                        graph[i][top] = value
                    else:
                        top += 1
                        graph[i][top] = value
    elif direction == 2: #남쪽
        for i in range(N):
            top = N - 1
            for j in range(N - 2, -1 , -1):
                if graph[j][i]:
                    value = graph[j][i]
                    graph[j][i] = 0
                    if graph[top][i] == value:
                        graph[top][i] = value * 2
                        top -= 1
                    elif graph[top][i] == 0:
                        graph[top][i] = value
                    else:
                        top -= 1
                        graph[top][i] = value
    else:#북쪽
        for i in range(N):
            top = 0
            for j in range(1, N):
                if graph[j][i]:
                    value = graph[j][i]
                    graph[j][i] = 0
                    if graph[top][i] == value:
                        graph[top][i] = value * 2
                        top += 1
                    elif graph[top][i] == 0:
                        graph[top][i] = value
                    else:
                        top += 1
                        graph[top][i] = value
    return graph

def dfs(graph, cnt):
    global answer
    if cnt == 5:
        for i in range(N):
            for j in range(N):
                answer = max(answer, graph[i][j])
        return
    
    #동,서,남,북 이동하는 경우를 다 따져야함.
    for i in range(4):
        new_graph = [temp[:] for temp in graph]
        result = move(new_graph, i)
        dfs(result, cnt + 1)


dfs(graph, 0)
print(answer)


