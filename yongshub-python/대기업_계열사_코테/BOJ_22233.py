import sys
input = sys.stdin.readline

N, M = map(int, input().split())
keywords = dict()
answer = N
answers = []
for _ in range(N):
    keywords[input().rstrip()] = False

for _ in range(M):
    posts = list(input().rstrip().split(','))
    for post in posts:
        try:
            if not keywords[post]:
                answer -= 1
                keywords[post] = True
        except:
            continue
    answers.append(answer)

for answer in answers:
    print(answer)