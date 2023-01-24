import sys
from collections import deque

input = sys.stdin.readline

N = int(input().rstrip()) # 지방의 수 N
budgets = list(map(int, input().split())) # 지방의 예산 요청들 list
total_budget = int(input().rstrip()) # 총 예산

stack = []

# 오름차순 정렬 및 deque화
budgets.sort()
budgets = deque(budgets)

# stack을 활용한 풀이
while budgets:
    next_budget = budgets.popleft() # 작은 예산 요청부터 pop
    if total_budget - next_budget < 0: # 남은 예산에 비해 예산 요청이 클 경우
        value = total_budget // N
        while stack:
            total_budget += stack.pop() # 총 예산에 스택의 마지막 요소를 다시 추가
            N = N + 1 # 개수 다시 추가
            value = total_budget // N
            if stack and value > stack[-1]: # 스택이 존재하고 나눈 비용이 스택의 마지막 요소보다 크다면?
                break
        stack.append(value)
        break
    else:
        total_budget -= next_budget # 남은 예산 감소
        stack.append(next_budget) # 스택에 추가
        N -= 1 # 개수 감소

print(max(stack)) # 배정된 예산들 중 최댓값 정수 출력