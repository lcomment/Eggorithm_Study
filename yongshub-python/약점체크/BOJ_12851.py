import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())

#Memozation 기법
visited = [100000] * 100001
minValue = int(1e9)
totalCount = 0
def checkCount(count):
    global minValue, totalCount
    if count == minValue:
        totalCount += 1
    elif count < minValue:
        minValue = count
        totalCount = 1


def bfs(start, end):
    global minValue
    visited[start] = 0
    deq = deque([(start, 0)])
    if start == end:
        return False
    while deq:
        location, count = deq.popleft()

        value_1 = location - 1 if 0 <= location - 1 <= 100000 else -1 # -1
        value_2 = location + 1 if 0 <= location + 1 <= 100000 else -1 # + 1
        value_3 = location * 2 if 0 <= location * 2 <= 100000 else -1 # * 2
    
        if value_1 >= 0 and count + 1 <= visited[value_1]: # 값은 0보다 크거나 값고 기록되어 있는 시간 작거나 같을 때
            visited[value_1] = count + 1 # 기록
            if value_1 == end: # value가 도착정보와 같을때
                checkCount(visited[value_1])
            else:
                if visited[value_1] < minValue: #최소시간보다 작을때만 큐에 삽입
                    deq.append((value_1, count + 1))
        
        if value_2 >= 0 and count + 1 <= visited[value_2]:
            visited[value_2] = count + 1
            if value_2 == end:# value가 도착정보와 같을때
                checkCount(visited[value_2])
            else:
                if visited[value_2] < minValue:
                    deq.append((value_2, count + 1))
        
        if value_3 >= 0 and count + 1 <= visited[value_3]:
            visited[value_3] = count + 1
            if value_3 == end: # value가 도착정보와 같을때
                checkCount(visited[value_3])
            else:
                if visited[value_3] < minValue:
                    deq.append((value_3, count + 1))
    return True



if bfs(N, K):
    print(minValue)
    print(totalCount)
else:
    print(0)
    print(1)