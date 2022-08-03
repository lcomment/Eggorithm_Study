from itertools import permutations

n = int(input())
num_list = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

operators = []
operators += ['+'] * add
operators += ['-'] * sub
operators += ['*'] * mul
operators += ['%'] * div


# 연산자의 모든 경우의 수 구하기
operators = set(list(permutations(operators)))

res_list = []
for i in operators:
    # 첫번째 값 
    res = num_list[0]
    # n : 숫자 개수, n-1 : 연산자 개수
    for j in range(n-1):
        # 현재 수와 그 다음 수의 연산 실행
        if i[j] == '+':
            res += num_list[j+1]
        elif i[j] == '-':
            res -= num_list[j+1]
        elif i[j] == '*':
            res *= num_list[j+1]
        else:
            # 음수 나누기 일 때
            if res < 0:
                res = -(-res // num_list[j+1])
            else:
                res //= num_list[j+1]
    res_list.append(res)
        
print(max(res_list))
print(min(res_list))