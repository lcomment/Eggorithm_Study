import sys
input = sys.stdin.readline
S = list(input().rstrip())
zero_cnt, one_cnt = S.count('0') // 2, S.count('1') // 2

for _ in range(zero_cnt):
    S.pop(-S[::-1].index('0') - 1)
for _ in range(one_cnt):
    S.pop(S.index('1'))
print(''.join(S))