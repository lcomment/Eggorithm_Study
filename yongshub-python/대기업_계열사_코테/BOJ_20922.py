#홍대병에 걸린 도현이는 겹치는 것을 매우 싫어한다. 특히 수열에서 같은 원소가 여러 개 들어 있는 수열을 싫어한다. 도현이를 위해 같은 원소가 $K$개 이하로 들어 있는 최장 연속 부분 수열의 길이를 구하려고 한다.
#100000 이하의 양의 정수로 이루어진 길이가 N인 수열이 주어진다.  이 수열에서 같은 정수를 K개 이하로 포함한 최장 연속 부분 수열의 길이를 구하는 프로그램을 작성해보자.
import sys
input = sys.stdin.readline


# 투 포인터를 활용한 문제
N, K = map(int, input().split())
numbers = list(map(int, input().split()))
visited = [0] * 1000001
start, end = 0, 0
maxLength = 0
while True:
    if end == N:
        break
    if visited[numbers[end]] + 1 > K:
        visited[numbers[start]] -= 1
        start += 1
    else:
        visited[numbers[end]] += 1
        length = end - start + 1
        maxLength = max(maxLength, length)
        end += 1
print(maxLength)