import sys
from collections import defaultdict

input = sys.stdin.readline
N, M = map(int, input().split())
names = defaultdict(str)
numbers = defaultdict(int)
lst = []
for i in range(1, N + 1):
    pocketmon = input().rstrip()
    names[pocketmon] = i
    numbers[i] = pocketmon

problems = [input().rstrip() for _ in range(M)]

for problem in problems:
    if problem.isnumeric():  # 숫자라면
        print(numbers[int(problem)])
    else:
        print(names[problem])
