import sys

# 1. 창고에는 모든 기둥이 들어간다
# 지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
# 지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
# 지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
# 지붕의 가장자리는 땅에 닿아야 한다.
# 비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.
#첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다. 
#N은 1 이상 1,000 이하이다. 그 다음 N 개의 줄에는 각 줄에 각 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다. 
#L과 H는 둘 다 1 이상 1,000 이하이다.
input = sys.stdin.readline

N = int(input().rstrip())
rods = []
for _ in range(N):
    rods.append(list(map(int, input().split())))

#1. 정렬
rods.sort(key=lambda x: x[0])

#2. maxValue
max_height = max(rods, key=lambda x: (x[1], x[0]))
max_idx = 0
answer = 0

for idx, value in enumerate(rods):
    if value[1] == max_height[1]:
        max_idx = idx

prev_node = rods[:max_idx + 1]
next_node = rods[max_idx + 1:]

current_idx = 0
for idx, value in enumerate(prev_node):
    try:
        next = prev_node[idx + 1]
        if next[1] < prev_node[current_idx][1]:
            continue
        else:
            answer += (next[0] - prev_node[current_idx][0]) * prev_node[current_idx][1]
            current_idx = idx + 1
    except:
        pass

answer += max_height[1]
current_location = max_height[0]
new_node = []

for node in next_node:
    if len(new_node) == 0:
        new_node.append(node)
    else:
        while True:
            if len(new_node) == 0:
                new_node.append(node)
                break
            elif new_node[-1][1] < node[1]:
                new_node.pop()
            else:
                new_node.append(node)
                break

for value in new_node:
    location, height = value[0], value[1]
    answer += (location - current_location) * height
    current_location = location
print(answer)