import sys
input = sys.stdin.readline

N = int(input().rstrip())
result = 0
for i in range(1, N + 1):
  if i % 2 == 0:
    result += i
print(result)