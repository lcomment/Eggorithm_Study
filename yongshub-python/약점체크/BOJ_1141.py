import sys
input = sys.stdin.readline

words = []
cnt = 0
n = int(input().rstrip())
for _ in range(n):
    words.append(input().rstrip())
words.sort(key=lambda x: len(x))
for i in range(n):
    length = len(words[i])
    flag = False
    for j in range(i + 1, n):
        if words[i] == words[j][:length]:
            flag = True
            break
    if not flag:
        cnt += 1
print(cnt)
