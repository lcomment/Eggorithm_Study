import sys

testCases = []
result = []
visited = [False] * 50
arr = [0] * 6

while True:
    lst = list(map(int, sys.stdin.readline().split()))
    if lst[0] == 0:
        break
    testCases.append(lst)


def solution(k, testCase):
    if(k == 6):  # 6번째라면
        res = arr[:6]
        res.sort()  # 정렬 후
        result.append(tuple(res))  # result에 추가
        return None

    for i in testCase:
        if visited[i] is False:
            visited[i] = True
            arr[k] = i
            solution(k + 1, testCase)
            visited[i] = False


for testCase in testCases:
    solution(0, testCase[1:])  # 1:
    result = set(result)  # 중복된 요소 제거
    result = sorted(result)  # 정렬
    for res in result:
        print(*res)
    print()
    result = []
