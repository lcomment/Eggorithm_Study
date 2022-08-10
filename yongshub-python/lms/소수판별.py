import sys

input = sys.stdin.readline
N = int(input().rstrip())
def isPrime(N):
  for i in range(2, N):
    if N % i == 0:
      return False
  return True

if N > 2:
  if isPrime(N):
    print('YES')
  else:
    print('NO')
else:
  print('YES')