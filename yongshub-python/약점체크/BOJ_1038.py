import sys
from itertools import combinations
input = sys.stdin.readline
N = int(input().rstrip())
nums = []
for i in range(1, 11):
    for result in combinations(range(0, 10), i):
        result = list(result)
        result.sort(reverse=True)
        nums.append(int(''.join(map(str, result))))

nums.sort()

try:
    print(nums[N])
except:
    print(-1)



