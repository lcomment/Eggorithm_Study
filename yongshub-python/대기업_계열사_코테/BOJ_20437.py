# 알파벳 소문자로 이루어진 문자열 W
# 양의 정수 K
# 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
# 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다.
# 위와 같은 방식으로 게임을 T회 진행
# 게임 수 T(1 <= T <= 100) 다음 줄 부터 2개의 줄 동안 문자열 W와 정수 K (1 <= K <= W <= 10000)
import sys
from collections import defaultdict
input = sys.stdin.readline
T = int(input().rstrip())
def findLengthwithK(string, k):
    data_dict = defaultdict(list)
    for i in range(len(string)):
        if string.count(string[i]) >= k:
            data_dict[string[i]].append(i)
    for index_list in data_dict.values():
        for j in range(len(index_list) - k + 1):
            length = index_list[j + k - 1] - index_list[j] + 1
            record[0] = min(record[0], length)
            record[1] = max(record[1], length)



for _ in range(T): # 게임 T번 진행
    string = input().rstrip() # 문자열 입력받음
    k = int(input().rstrip()) # k입력 받음
    record = [int(10e9), 0] # 점수 기록
    findLengthwithK(string, k)
    print(-1) if record[0] == int(10e9) else print(record[0], record[1])
