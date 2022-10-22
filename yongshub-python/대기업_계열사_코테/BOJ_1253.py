import sys
input = sys.stdin.readline
N = int(input().rstrip())
A = list(map(int, input().split()))
A.sort()
cnt = 0
for i in range(N):
    temp = A[:i] + A[i+1:]
    start, end = 0, len(temp) - 1

    while start < end:
        total = temp[start] + temp[end]
        if total == A[i]:
            cnt += 1
            break
        elif total < A[i]:
            start += 1
        else:
            end -= 1
print(cnt)