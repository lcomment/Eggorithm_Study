import sys

input = sys.stdin.readline

for _ in range(3):
  result = list(map(int, input().split()))
  zero, one = result.count(0), result.count(1)
  
  if zero == 1 and one == 3:
    print('A')
  elif zero == 2 and one == 2:
    print('B')
  elif zero == 3 and one == 1:
    print('C')
  elif zero == 4:
    print('D')
  else:
    print('E')