import sys
input = sys.stdin.readline
N, M, L, K = map(int, input().split()) # 1 <= N, M <= 500,000, 1 <= K <= 100 N은 별똥별 떨어지는 구역의 가로길이, M은 세로, L은 트렘펄린 한 변의 길이 K는 별똥별 수
answer = K
positions = []
for _ in range(K):
    x, y = map(int, input().split())
    positions.append((x, y))

for i in range(K):
    for j in range(K):
        cnt = 0
        x = positions[i][0]
        y = positions[j][1]
        for k in range(K):
            nx, ny = positions[k][0], positions[k][1]
            if x <= nx <= x + L and y <= ny <= y + L:
                cnt += 1
        answer = min(answer, K - cnt)
print(answer)
