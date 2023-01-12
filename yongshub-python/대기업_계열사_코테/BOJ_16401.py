import sys

input = sys.stdin.readline

# 나눠준 과자의 길이가 하나라도 다르면 조카끼리 싸움이 일어난다 -> 반드시 몯든 조카에게 같은 길이의 막대 과자를 나눠주어야 한다.
# M명의 조카가 있고 N개의 과자가 있을 때, 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 구하기.
M, N = map(int, input().split()) # M은 조카의 수, N은 과자의 수
snacks = list(map(int, input().split()))
snacks.sort()

def binary_search(M, N):
    start = 1 # 최소값
    end = snacks[-1] # 최대값
    answer = 0
    
    while start <= end:
        middle = (start + end) // 2
        count = 0

        for i in range(N):
            if snacks[i] >= middle:
                count += (snacks[i]) // middle # 몫의 개수로 더하기
        
        if count >= M:
            answer = middle
            start = middle + 1
        else:
            end = middle - 1
    return answer


answer = binary_search(M, N)
print(answer)