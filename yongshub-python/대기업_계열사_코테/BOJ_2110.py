# 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
# 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고,
# 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
# C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
#  간격을 x 로 해서 주어진 C 개의 공유기를 모두 설치할 수 있으면 해당 x 는 정답으로 가능한 값에 속하는 것
import sys

input = sys.stdin.readline
# 2 <= N <= 200,000, 2 <= C <= N
N, C = map(int, input().split())
locations = [int(input().rstrip()) for _ in range(N)]
locations.sort()
answer = 0
def binary_search(start, end):
    global answer
    
    while start <= end:
        mid = (start + end) // 2
        current = locations[0]
        count = 1

        for i in range(1, len(locations)):
            if locations[i] >= current + mid:
                count += 1
                current =locations[i]

        if count >= C:
            start = mid + 1
            answer = mid
        else:
            end = mid - 1


start = 1
end =locations[-1] -locations[0]

binary_search(start, end)
print(answer)