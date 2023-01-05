import sys

input = sys.stdin.readline

graph = []
#상,하,좌,우,왼쪽 위 대각선, 오른쪽 위 대각선, 왼쪽 아래 대각선, 오른쪽 아래 대각선
dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

def checkCoordinate(x, y):
    value = nodes[x][y]
    cnt = 1
    # 방향대로 3칸씩 이동하며 같은지 체크
    for i in range(8):
        nx, ny = x, y
        for _ in range(2):
            nx, ny  = nx + dx[i], ny + dy[i]
            if nx < 0 or nx >= 3 or ny < 0 or ny >= 3:
                break
            if nodes[nx][ny] == value:
                cnt += 1
            else:
                break
            
        if cnt == 3:
            return True
        else:
            cnt = 1
    return False


def checkInRowCircle():
    for i in range(3):
        for j in range(3):
            if nodes[i][j] == 'O':
                result = checkCoordinate(i, j)
                if result:
                    return True
    return False

def checkInRowX():
    for i in range(3):
        for j in range(3):
            if nodes[i][j] == 'X':
                result = checkCoordinate(i, j)
                if result:
                    return True
    return False

while True:
    line = input().rstrip()
    if line == 'end':
        break
    graph.append(line)


for line in graph:
    nodes = []
    x_count, o_count = 0, 0 # 'X'개수, 'O' 개수
    for i in range(0, 9, 3):
        row = line[i:i + 3] # ex) OXOXOXXXO OXO, XOX, XXO 3개씩 자르기 
        x_count += row.count('X')
        o_count += row.count('O')
        nodes.append(list(row))

    check_O = checkInRowCircle() # 'O'연속 여부 체크


    if check_O: # O가 연속되었다면 
        if x_count == o_count: # O와X개수는 무조건 같아야함
            print('valid')
        else:
            print('invalid')
        continue

    check_X = checkInRowX() # 'X' 연속 여부 체크

    if check_X: # 'X'가 연속되었다면
        if x_count - 1 == o_count: # 'X'개수는 무조건 O보다 1개 많아야함
            print('valid')
        else:
            print('invalid')
        continue

    if x_count == 5 and o_count == 4: # x개수가 5개, o개수가 4개는 꽉 찬 것.
        print('valid')
        continue
    print('invalid')
