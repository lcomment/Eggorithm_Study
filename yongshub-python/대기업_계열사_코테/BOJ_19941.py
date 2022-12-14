import sys

input = sys.stdin.readline

N, K = map(int, input().split())
strings = input().rstrip()

visited = [False] * N
cnt = 0
for idx, value in enumerate(strings):
    if value == 'P':
        for i in range(max(idx - K, 0), min(idx + K + 1, N)):
            if strings[i] == 'H' and not visited[i]:
                visited[i] = True
                cnt += 1
                break
print(cnt)