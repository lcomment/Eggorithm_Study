import sys
input = sys.stdin.readline
from collections import deque
# N명의 사람들은 매일 아침 한 줄로 섬 자리를 마음대로 서지 못하고 오민식의 지시대로 서야함
# 오민식은 사람들이 줄 서는 위치를 기록해놓음. 아침에 기록해놓은 것과 사람들이 줄을 선 위치가 맞는지 확인함
# 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억하고 N명의 사람이 있고 사람들의 키는 1부터 N까지 모두 다르다.
# 각 사람들이 기억하는 정보가 주어질 때 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성
# 입력: 첫째 줄에 사람의 수 N N은 10보다 작거나 같은 자연수 둘째 줄에는 키가 1인사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇명 있었는지 주어짐.
N = int(input().rstrip())
lines = list(map(int, input().split()))
new_stack = []
for i in range(N -1, -1 ,-1):
    new_stack.insert(lines[i], i + 1) #lines[i]번쨰 삽입해야 내 앞에 lines[i]만큼 존재함
print(*new_stack)