import sys
input = sys.stdin.readline
from itertools import combinations
N = int(input().rstrip())
words = [input().rstrip() for _ in range(N)]
answer = 0
length = len(words[0])
def compareSameLength(temp, length):
    temp_case = list(combinations(temp, length))
    word_case = list(combinations(words[0], length))
    for case_t in temp_case:
        for case_w in word_case:
            if sorted(case_t) == sorted(case_w):
                return 1
    return 0


for word in words[1:]:
    temp_length = len(word)
    if temp_length == length:
        answer += compareSameLength(word, temp_length - 1)
    elif temp_length == length + 1:
        answer += compareSameLength(word, length)
    elif temp_length == length - 1:
        answer += compareSameLength(word, temp_length)
print(answer)