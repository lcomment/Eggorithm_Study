import sys
input = sys.stdin.readline
fishes = []
nets = []
# N 모눈종이의 크기, ㅣ: 그물의 길이, M: 물고기의 수
N, L, M = map(int, input().split())
answer = 0
for _ in range(M):
    fishes.append(tuple(map(int, input().split())))
for i in range(1, L):
    width = L - (2 * i)
    if width <= 0:
        break
    elif width % 2 == 0:
        nets.append((i, width // 2))

for i in range(M):
    x = fishes[i][0]
    for j in range(M):
        y = fishes[j][1]
        for net_x, net_y in nets:
            cnt = 0
            for k in range(M):
                if x <= fishes[k][0] <= x + net_x and y <= fishes[k][1] <= y + net_y:
                    cnt += 1
            answer = max(answer, cnt)
print(answer)
