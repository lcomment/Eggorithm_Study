import heapq
import sys

input = sys.stdin.readline
N = int(input().rstrip())

leftHeap = []  # 최소 힙
rightHeap = []  # 최대 힙

for _ in range(N):
    value = int(input().rstrip())
    if len(leftHeap) == len(rightHeap):  # 왼쪽부터 삽입한다는 의미
        heapq.heappush(leftHeap, -value)  # 파이썬은 heap을 최소힙만 지원하기 때문에 -붙여서 삽입
    else:
        heapq.heappush(rightHeap, value)

    if rightHeap and rightHeap[0] < -leftHeap[0]:
        right = heapq.heappop(rightHeap)
        left = heapq.heappop(leftHeap)
        heapq.heappush(rightHeap, -left)
        heapq.heappush(leftHeap, -right)
    print(-leftHeap[0])
