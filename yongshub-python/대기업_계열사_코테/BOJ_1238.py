import sys
input = sys.stdin.readline
import heapq as heap
#N명의 학생과 N개의 마을
N, M, X = map(int, input().split())
costs = [[0] * (N + 1) for _ in range(N + 1)]
graph = [[] * 1 for _ in range(N + 1)]
answer = []
def dijkstra(start):
    distance = [int(10e9)] * (N + 1)
    visited = [False] * (N + 1)
    distance[start] = 0
    visited[start] = True
    nodes = []
    for end in graph[start]:
        distance[end] = costs[start][end]
        nodes.append((distance[end], end))
    heap.heapify(nodes)

    while nodes:
        now_cost, now = heap.heappop(nodes)
        if not visited[now]:
            visited[now] = True
            for next in graph[now]:
                cost = now_cost + costs[now][next]
                if cost < distance[next]:
                    distance[next] = cost
                    heap.heappush(nodes, (distance[next], next))
    return distance    

for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append(end)
    costs[start][end] = cost

return_distance = dijkstra(X) # 돌아갈 때 최단 경로 저장

for i in range(1, N + 1):
    if i == X:
        continue
    else:
        distance1, distance2 = dijkstra(i), return_distance[i]
        answer.append(distance1[X] + distance2)
print(max(answer)) 

