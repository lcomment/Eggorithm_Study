import sys
from collections import defaultdict
from collections import deque

def changeType(input):
    if input.isnumeric():
        return int(input)
    return input

input = sys.stdin.readline 

N, M = map(int, input().split())
style = [list(map(changeType, input().split())) for _ in range(N)]
style.sort(key=lambda x: x[1]) # 전투력 상한값으로 오름차순 정렬
combat_power = []
ascend_style = []
orders = defaultdict(str)
prev = 0
for key, value in style:
    ascend_style.append((prev, value, key))
    prev = value + 1

for i in range(M):
    number = int(input().rstrip())
    combat_power.append(number)

ascend_combat_power = deque(sorted(combat_power))

for value in ascend_style:
    while ascend_combat_power:
        power = ascend_combat_power.popleft()
        if value[0] <= power <= value[1]:
            orders[power] = value[2]
        else:
            ascend_combat_power.appendleft(power)
            break

for power in combat_power:
    print(orders[power])


    

