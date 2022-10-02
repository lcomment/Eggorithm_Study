from collections import defaultdict
from heapq import heappop, heappush


# n: 노드 수
# gates: 출입구, sumits: 산봉우리
def solution(n, paths, gates, summits):
    def get_min_intensity():
        pq = []  # (intensity, 현재 위치)
        visited = [10000001] * (n + 1)

        # 모든 출발지를 우선순위 큐에 삽입
        for gate in gates:
            heappush(pq, (0, gate))
            visited[gate] = 0

        # 산봉우리에 도착할 때까지 반복
        while pq:
            intensity, node = heappop(pq)

            # 산봉우리이거나 더 큰 intensity라면 더 이상 이동하지 않음
            if node in summits_set or intensity > visited[node]:
                continue

            # 이번 위치에서 이동할 수 있는 곳으로 이동
            for weight, next_node in graph[node]:
                # next_node 위치에 더 작은 intensity로 도착할 수 있다면 큐에 넣지 않음
                # (출입구는 이미 0으로 세팅되어있기 때문에 방문하지 않음)
                new_intensity = max(intensity, weight)
                if new_intensity < visited[next_node]:
                    visited[next_node] = new_intensity
                    heappush(pq, (new_intensity, next_node))

        # 구한 intensity 중 가장 작은 값 반환
        min_intensity = [0, 10000001]
        for summit in summits:
            if visited[summit] < min_intensity[1]:
                min_intensity[0] = summit
                min_intensity[1] = visited[summit]

        return min_intensity

    summits.sort()
    summits_set = set(summits)
    # graph: 등산로 정보
    graph = defaultdict(list)
    for i, j, w in paths:
        graph[i].append((w, j))
        graph[j].append((w, i))

    return get_min_intensity()