# 세준시에는 고층 빌딩이 많다. 세준시의 서민 김지민은 가장 많은 고층 빌딩이 보이는 고층 빌딩을 찾으려고 한다. 
# 빌딩은 총 N개가 있는데, 빌딩은 선분으로 나타낸다. i번째 빌딩 (1부터 시작)은 (i,0)부터 (i,높이)의 선분으로 나타낼 수 있다. 
# 고층 빌딩 A에서 다른 고층 빌딩 B가 볼 수 있는 빌딩이 되려면, 두 지붕을 잇는 선분이 A와 B를 제외한 다른 고층 빌딩을 지나거나 접하지 않아야 한다. 가장 많은 고층 빌딩이 보이는 빌딩을 구하고, 거기서 보이는 빌딩의 수를 출력하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 빌딩의 수 N, N은 50보다 작거나 같은 자연수이다. 둘째 줄에 1번 빌딩부터 그 높이가 주어짐. 높이는 1,000,000,000보다 작거나 같은 자연수이다.

import sys

input = sys.stdin.readline

N = int(input().rstrip())
buildings = list(map(int, input().split()))
answer = 0

def getBuildingCount(i, j): # 일차 방정식  y - y1 = (x2 - x1) / (y2 - y1) (x - x1) 를 활용
    cnt = 0
    coordination_1 = (i + 1, buildings[i]) # 첫번째 좌표
    coordination_2 = (j + 1, buildings[j]) # 두번째 좌표
    inclination = (coordination_2[1] - coordination_1[1]) / (coordination_2[0] - coordination_1[0]) # 기울기
    for location in range(i + 1, j):
        x, y = location + 1, buildings[location]
        height = inclination * (x - coordination_1[0]) + coordination_1[1]
        if height <= y:
            return 0
    return 1




for i in range(N):
    cnt = 0
    for j in range(N):
        if i == j:
            continue
        elif i < j:
            cnt += getBuildingCount(i, j)
        elif i > j:
            cnt += getBuildingCount(j, i)
    answer = max(answer, cnt)

print(answer)