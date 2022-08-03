import sys
input = sys.stdin.readline
graph = []
mst = []
p = [0] # 상호베타적 집합
V, E = map(int, input().split())
for _ in range(E):
    A, B, C = map(int, input().split())
    graph.append((A, B, C))

#가중치로 간선 정렬
graph.sort(key = lambda x: x[2])

#각 정점 자신이 집합의 대표
for i in range(1, V + 1):
    p.append(i)


def find(u):
    if u != p[u]:
        p[u] = find(p[u])
    return p[u]

def union(u, v):
    root1 = find(u)
    root2 = find(v)
    p[root2] =root1


tree_edges = 0
mst_cost = 0
while True:
    if tree_edges == V - 1: # 간선이 정점 N - 1일때
        break
    u, v, wt = graph.pop(0)
    if find(u) != find(v): #u와 v가 서로 다른 집합에 속해 있으면
        union(u, v)
        mst.append((u, v))
        mst_cost += wt
        tree_edges += 1

print(mst_cost)

