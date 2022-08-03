import sys

input = sys.stdin.readline

N, M = map(int, input().split())
answer = 0
lst = []
for _ in range(M):
    price = tuple(map(int, input().split()))
    lst.append(price)

six_lst = sorted(lst, key=lambda x: x[0])
one_lst = sorted(lst, key=lambda x: x[1])

if six_lst[0][0] <= one_lst[0][1] * 6:
    answer = six_lst[0][0] * (N // 6) + one_lst[0][1] * (N % 6)
    if six_lst[0][0] < one_lst[0][1] * (N % 6):
        answer = six_lst[0][0] * (N // 6 + 1)
else:
    answer = one_lst[0][1] * N

print(answer)