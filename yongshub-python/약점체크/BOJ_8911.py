import sys
input = sys.stdin.readline

n = int(input().rstrip())
locations = dict()
# L, R, F, B
locations['up'] = ['left', 'right', (0, 1), (0, -1)]
locations['down'] = ['right', 'left', (0, -1), (0, 1)]
locations['left'] = ['down', 'up', (-1, 0), (1, 0)]
locations['right'] = ['up', 'down', (1, 0), (-1, 0)]
for _ in range(n):
    case = input().rstrip()
    current_location = 'up'
    min_row, max_row = 0, 0
    min_column, max_column = 0, 0
    start = (0, 0)
    for direct in case:
        if direct == 'F':
            nx, ny = locations[current_location][2]
            start = (start[0] + nx, start[1] + ny)
        elif direct == 'B':
            nx, ny = locations[current_location][3]
            start = (start[0] + nx, start[1] + ny)
        elif direct == 'L':
            current_location = locations[current_location][0]
        else:
            current_location = locations[current_location][1]
        min_row = min(min_row, start[0])
        max_row = max(max_row, start[0])
        min_column = min(min_column, start[1])
        max_column = max(max_column, start[1])
    print((max_row - min_row) * (max_column - min_column))
    
