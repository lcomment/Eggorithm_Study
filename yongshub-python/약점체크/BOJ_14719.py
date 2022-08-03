import sys
input = sys.stdin.readline

H, W = map(int, input().split())
blocks = list(map(int, input().split()))
graph = [[False] * W for _ in range(H)]
result = 0
# 1. 블록을 채우는 방법
for i in range(W): # 가로길이만큼 
    for j in range(H - 1, H - 1 - blocks[i], -1): # blocks[j] 인덱스 값만큼 행의 마지막요소부터 채워진다.
        graph[j][i] = True

# 2. 고이는 빗물을 계산하는 로직! 투포인터 적용
for i in range(H - 1, -1, -1):
    cnt = 0
    check = False
    for j in range(W):
        if graph[i][j] == True:
            if check:
                if cnt == 0: # 아직 빈공간을 만나지 않았다면
                    continue
                result += cnt
                cnt = 0
            else:
                check = True
        elif graph[i][j] == False:
            if check:
                cnt += 1

if H == 1 and W == 1 and blocks[0] == 0:
    print(1)
else:
    print(result)


