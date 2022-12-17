import sys
import heapq
input = sys.stdin.readline

#찬솔이는 블로그를 시작한 지 벌써 N일이 지났다.
#요즘 바빠서 관리를 못 했다가 방문 기록을 봤더니 벌써 누적 방문 수가 6만을 넘었다.
#찬솔이는 X일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
#찬솔이를 대신해서 X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구해주자.

N, X = map(int, input().split())
visited = list(map(int, input().split()))

sum_visited = [] # X일만큼의 최대 누적 합 
start = 0
current_value = 0
i = 0
isVisited = False
while True:
    if i == N:
        break
    elif i < X:
        current_value += visited[i]
    elif i == X and not isVisited:
        heapq.heappush(sum_visited, -current_value)
        i -= 1
        isVisited = True
    else:
        current_value -= visited[start]
        current_value += visited[i]
        heapq.heappush(sum_visited, -current_value)
        start += 1
    i += 1


max_visited = heapq.heappop(sum_visited)
if max_visited == 0:
    print('SAD')
else:
    cnt = 1
    print(-max_visited)
    while sum_visited:
        if max_visited == heapq.heappop(sum_visited):
            cnt += 1
        else:
            break
    print(cnt)

