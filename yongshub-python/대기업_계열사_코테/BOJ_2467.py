#KOI 부설 과학연구소 -> 많은 종류의 산성용액과 알칼리성 용액 보유
#각 용액은 그 용액의 특성을 나타내는 하나의 정수 1 ~ 1000000000 알칼리 -1 ~ -1000000000

# 같은 양의 두 용액을 혼합한 용액의 특성값 -> 혼합에 사용된 각 용액의 특성값의 합으로 정의
# 목적 -> 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들기
# 두 종류의 알카리성 용액이나 두 종류의 산성 용액만으로 특성값이 0에 가장 가까울 수도 있다.

# 시간 초과 로직
# import sys
# from itertools import combinations
# input = sys.stdin.readline

# min_value = (2000000000, 0, 0) # 최악의 경우, 1000000000 + 1000000000 가 0에 가까울수도 있어서 초기값 설정
# N = int(input().rstrip())
# types = list(map(int, input().split()))

# for case in combinations(types, 2): # 조합 문제
#     if abs(0 - sum(case)) < abs(0 - min_value[0]): # 0에서 두 용액의 합을 뺀 절대값을 비교
#         min_value = (abs(0 - sum(case)), case[0], case[1])

# print(*sorted(list(min_value[1:])))

import sys
input = sys.stdin.readline

N = int(input().rstrip())
types = list(map(int, input().split()))

left_idx = 0
right_idx = N - 1

ans = abs(types[left_idx] + types[right_idx])
ans_left = left_idx
ans_right = right_idx

while left_idx < right_idx: # left_idx와 right_idx는 만나면 안된다
    tmp = types[left_idx] + types[right_idx]

    if abs(tmp) < ans:
        ans_left = left_idx
        ans_right = right_idx
        ans = abs(tmp)

        if ans == 0:
            break
    
    if tmp < 0:
        left_idx += 1
    else:
        right_idx -= 1

print(types[ans_left], types[ans_right])

# -5, -4, 4, 5
# 1, 2, 3, 4, 6, 6

