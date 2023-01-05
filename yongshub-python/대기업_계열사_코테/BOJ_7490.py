import sys
from collections import deque
input = sys.stdin.readline

test_case = int(input().rstrip())

for _ in range(test_case):
    N = int(input().rstrip())
    numbers = [i for i in range(2, N + 1)] # 1부터 N까지 숫자 list 생성
    deq = deque([['1']])
    for number in numbers:
        new_deq = deque([])
        while deq:
            mathematical_expression = deq.popleft()
            for expression in ['', '+', '-']:
                new_mathematical_expression = mathematical_expression[:] #[:] 의미: 새롭게 복사 
                new_mathematical_expression.append(expression)
                new_mathematical_expression.append(str(number))
                new_deq.append(new_mathematical_expression)
        deq = new_deq
        
    for result in deq:
        expression = ''.join(result) # 배열 문자열로 join 즉, 합치기
        if eval(expression) == 0: # eval : 문자열 연산 함수
            isNumber = False
            for value in expression:
                if value.isnumeric():
                    if isNumber:
                        print('',value, end='')
                    else:
                        isNumber = True
                        print(value, end='')
                else:
                    print(value, end='')
                    isNumber = False

                
            print()
    print()


