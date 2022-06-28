import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input().rstrip())
day_to_score = []


def findMaxValue(day_to_score, i):
    maxScore = 0
    maxDay = 0
    for day, score in day_to_score:
        if day >= i and score > maxScore:
            maxScore = score
            maxDay = day
        elif day < i:
            break

    if maxScore != 0 and maxDay != 0:
        day_to_score.remove((maxDay, maxScore))
    return maxScore


for _ in range(N):
    d, w = map(int, input().split())
    day_to_score.append((d, w))

day_to_score.sort(key=lambda x: (-x[0], -x[1]))
max_day = day_to_score[0][0]
result = 0

for i in range(max_day, 0, -1):
    result += findMaxValue(day_to_score, i)

print(result)
