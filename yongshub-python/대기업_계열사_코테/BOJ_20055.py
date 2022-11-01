from collections import deque
import sys

input = sys.stdin.readline
n, k = map(int, input().split())
belt = deque(map(int, input().split()))
robots = deque([0]*(2*n))

def job_schedule(n, k):
    cnt = 1
    while True:
        #1. 컨베이어 벨트 회전, 로봇도 함께 회전
        belt.rotate(1)
        robots.rotate(1)
        #회전하고나서 n번 위치에 로봇이 있다면 제거
        robots[n-1] = 0

        for i in range(n-2,-1,-1):
            #2. 처음 들어간 로봇에서부터 순서대로 다음 곳을 들어갈 수 있는지 체크하고 내구도가 1이상인지 체크
            if robots[i] and not robots[i+1] and belt[i+1]:
                belt[i+1]-=1
                robots[i+1], robots[i] = robots[i], 0
            robots[n-1] = 0
        #3. 올리는 위치에 있는 칸의 내구도가 1이상이고 로봇이 존재하지 않는다면
        if not robots[0] and belt[0]:
            robots[0] = 1
            belt[0] -= 1
        #4. 내구도가 0인 칸 개수 체크
        if belt.count(0) >= k:
            print(cnt)
            break
        cnt += 1


job_schedule(n, k)