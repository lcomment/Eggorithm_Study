import sys

input = sys.stdin.readline

#몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.

A_COUNT, B_COUNT = map(int, input().split()) # 1 <= A, B <= 500,000
a_list = list(map(int, input().split()))
b_list = list(map(int, input().split()))
answer = []
cnt = 0
#1. 두 집합 모두 정렬
a_list.sort()
b_list.sort()
def binary_search(number):
    start, end = 0, len(b_list) - 1

    while start <= end:
        middle = (start + end) // 2

        if b_list[middle] == number:
            return True
        elif b_list[middle] < number:
            start = middle + 1
        else:
            end = middle - 1
    return False




for number in a_list:
    if not binary_search(number):
        answer.append(number)
        cnt += 1
print(cnt)
print(*answer)