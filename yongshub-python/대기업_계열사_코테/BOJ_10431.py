import sys

input = sys.stdin.readline

T = int(input().rstrip())

def validate(cases, end):
    for idx, case in enumerate(cases):
        if case > end:
            return idx
    return -1


def calculate(cases):
    end = 0
    cnt = 0
    while True:
        if end == len(cases):
            break

        idx = validate(cases[:end + 1], cases[end])

        if idx == -1:
            end += 1
        elif idx >= 0:
            cnt = cnt + (end - idx)
            value = cases.pop(end)
            cases.insert(idx, value)
            end += 1
        
    return cnt

for _ in range(T):
    cases = list(map(int, input().split()))
    N = cases.pop(0)
    cnt = calculate(cases)
    print(N, cnt)