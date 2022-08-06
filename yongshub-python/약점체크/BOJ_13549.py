import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())
minValue = int(1e9)
visited = [0] * 100001
def checkCount(count):
    global minValue
    if count < minValue:
        minValue = count

def bfs(start, end):
    global minValue
    if start == end:
        return False
    deq = deque([(start, 0)])
    visited[start] = 1

    while deq:
        location, count = deq.popleft()
        if count >= minValue:
            break
        value_1 = location - 1 if 0 <= location - 1 <= 100000 else -1
        value_2 = location + 1 if 0 <= location + 1 <= 100000 else -1
        value_3 = location * 2 if 0 <= location * 2 <= 100000 else -1
        if value_3 >= 0 and not visited[value_3]:
            visited[value_3] = 1
            if value_3 == end:
                checkCount(count)
            else:
                if start < end and visited[value_3] < minValue:
                    deq.appendleft((value_3, count))

        if value_1 >= 0 and not visited[value_1]:
            visited[value_1] = 1
            if value_1 == end:
                checkCount(count + 1)
            else:
                if visited[value_1] < minValue:
                    deq.append((value_1, count + 1))
        
        if value_2 >= 0 and not visited[value_2]:
            visited[value_2] = 1
            if value_2 == end:
                checkCount(count + 1)
            else:
                if visited[value_2] < minValue:
                    deq.append((value_2, count + 1))    
    return True

if bfs(N, K):
    print(minValue)
else:
    print(0)