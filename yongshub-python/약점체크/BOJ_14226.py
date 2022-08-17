import sys
from collections import deque
input = sys.stdin.readline
n = int(input().rstrip())
deq = deque()
deq.append((1, 0))  # [현재 이모티콘 개수, 클립보드 이모티콘 개수]
visited = dict()
visited[(1, 0)] = 0

while deq:
    s, c = deq.popleft()
    if s == n:
        print(visited[(s, c)])
        break
        
    # 1번 연산 : 화면에 있는 모든 이모티콘을 복사
    if (s, s) not in visited.keys():
        visited[(s, s)] = visited[(s, c)] + 1
        deq.append((s, s))
    # 2번 : 화면에 있는 모든 이모티콘 중 1개 삭제
    if (s-1, c) not in visited.keys():
        visited[(s-1, c)] = visited[(s, c)] + 1
        deq.append((s-1, c))
    # 3번 연산 : 클립보드에 있는 이모티콘을 붙여넣기
    if (s+c, c) not in visited.keys():
        visited[(s+c, c)] = visited[(s, c)] + 1
        deq.append((s+c, c))