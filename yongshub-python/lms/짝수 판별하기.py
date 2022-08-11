import sys
input = sys.stdin.readline

N = int(input().rstrip())

if N % 2 == 0:
  print('even')
else:
  print('not even')