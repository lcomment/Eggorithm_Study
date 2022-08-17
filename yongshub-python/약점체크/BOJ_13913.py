import sys
input = sys.stdin.readline
from collections import deque
# 튜플을 새롭게 생성하면서 시간 초과 발생
N, K = map(int, input().split())
visited = [int(1e9)] * 100001
route = dict()
def bfs():
    global N, K
    deq = deque([(N, 0)])
    answer = []
    while deq:
        location, time = deq.popleft()
        if location == K:
            print(time)
            answer.append(location)
            while True:
                if location == N:
                    break
                next = route[location]
                answer.append(next)
                location = next
            print(*answer[::-1])
            return
        time += 1
        if 0 <= location - 1 <= 100000:
            if time < visited[location - 1]:
                visited[location - 1] = time
                route[location - 1] = location
                deq.append((location - 1, time))
        
        if 0 <= location + 1 <= 100000:
            if time < visited[location + 1] and location <= K:
                visited[location + 1] = time
                route[location + 1] = location
                deq.append((location + 1, time))
        
        if 0 <= 2 * location <= 100000:
            if time < visited[2 * location] and location <= K:
                visited[2 * location] = time
                route[2 * location] = location
                deq.append((2 * location, time))

bfs()
