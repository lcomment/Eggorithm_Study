from collections import defaultdict
def countPairs(numbers, k):
    visited = defaultdict(list)
    for i in numbers:
        visited[i]
    cnt = 0
    for i in numbers:
        for j in numbers:
            if i + k == j and j not in visited[i]:
                visited[i].append(j)
                cnt += 1
    print(cnt)

result = countPairs([ 1, 1, 2, 2, 3, 3], 1)