import sys
from collections import deque
#from collections import defaultdict
input = sys.stdin.readline
# A와 B로만 이루어진 영어 단어가 존재 Ex) AB, BAA, AA, ABBA
# S와 T가 주어졌을 때, S -> T로 바꾸는 게임
# 가능한 연산 2가지 :  문자열 뒤에 A추가, 문자열의 뒤에 B를 추가하고 문자열 뒤집기
# 주어진 조건을 이용해서 S를 T로 만들 수 있는지 없는지
S = input().rstrip()
T = input().rstrip()
isPossible = 0
deq = deque([T])
while deq:
    start = deq.popleft()
    T_LENGTH = len(start)
    if start == S:
        isPossible = 1
        break
    else:
        try:
            T_LENGTH -= 1
            if start[-1] == 'A':
                deq.append(start[:T_LENGTH])
            if start[0] == 'B':
                start = start[1:][::-1]
                deq.append(start)
        except:
            pass
print(isPossible)