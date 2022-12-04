import sys

def changeType(input):
    if input.isnumeric():
        return int(input)
    return input

input = sys.stdin.readline 

N, M = map(int, input().split())
style = [list(map(changeType, input().split())) for _ in range(N)]
style.sort(key=lambda x: x[1]) # 전투력 상한값으로 오름차순 정렬

visited = [''] * (style[-1][1] + 1)
prev = 0
for key, value in style:
    visited[value] = key
    prev = value + 1

for _ in range(M):
    number = int(input().rstrip())
    while True:
        if visited[number] != '':
            print(visited[number])
            break
        number += 1


