import sys
from collections import deque

input = sys.stdin.readline

N, M, X, Y, K = map(int, input().split()) # 세로, 가로, 좌표 (X, Y), K: 명령 개수
graph = list(list(map(int, input().split())) for _ in range(N))
orders = deque(list(map(int, input().split())))

#동, 서, 북, 남
dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]

#주사위
dices = [0, 0, 0, 0, 0, 0]

#북쪽으로 이동
def move_to_north():
    stack = []
    for _ in range(3):
        stack.append(dices.pop(1))
    
    while stack:
        dices.insert(0, stack.pop())


#남쪽으로 이동
def move_to_south():
    dices.insert(0, dices.pop(3))


#서쪽으로 이동
def move_to_west():
    values = (dices[0], dices[2], dices[-2], dices[-1])
    dices[-2], dices[-1], dices[0], dices[2] = values[0], values[1], values[3], values[2]

#동쪽으로 이동
def move_to_east():
    values = (dices[0], dices[2], dices[-2], dices[-1])
    dices[-2], dices[-1], dices[0], dices[2] = values[1], values[0], values[2], values[3]


def move(direction):
    if direction == 4:
        move_to_south()
    elif direction == 3:
        move_to_north()
    elif direction == 2:
        move_to_west()
    else:
        move_to_east()


while orders:
    direction = orders.popleft()

    if X + dx[direction] < 0 or X + dx[direction] >= N or Y + dy[direction] < 0 or Y + dy[direction] >= M:
        continue

    #주사위 굴리기
    move(direction)

    #좌표 변경
    X += dx[direction]
    Y += dy[direction]

    #이동한 칸에 쓰여 있는 수가 0인 경우
    if graph[X][Y] == 0:
        graph[X][Y] = dices[2]
        print(dices[0])
    elif graph[X][Y] != 0: # 0이 아닌경우
        dices[2] = graph[X][Y]
        graph[X][Y] = 0
        print(dices[0])
