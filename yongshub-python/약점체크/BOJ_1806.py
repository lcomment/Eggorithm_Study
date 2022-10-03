import sys
input = sys.stdin.readline
N, S = map(int, input().split())
arr = list(map(int, input().split()))
min_value = 100000001
start, end = 0, 0
sum_value = 0
while True:
    if sum_value < S:
        if end == N:
            break
        sum_value += arr[end]
        end += 1
    else:
        if end == N + 1:
            break
        elif sum_value - arr[start] >= S:
            min_value = min(min_value, end - (start + 1))
        else:
            min_value = min(min_value, end - start)
        sum_value -= arr[start]
        start += 1
        if min_value == 1: break
print(0) if min_value == 100000001 else print(min_value)
