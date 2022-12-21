import sys
import heapq

input = sys.stdin.readline

N = int(input().rstrip())
heap = []
for _ in range(N):
    line = list(map(int, input().split()))

    for number in line:
        if len(heap) < N:
            heapq.heappush(heap, number)
        else:
            if heap[0] < number:
                heapq.heappop(heap)
                heapq.heappush(heap, number)

print(heap[0])



