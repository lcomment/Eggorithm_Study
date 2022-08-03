#시간 초과 풀이
# import sys
# input = sys.stdin.readline
# from itertools import combinations

# N, K = map(int, input().split())
# words = []
# default = set({'a', 'n', 't', 'i', 'c'})
# cases = set().union(default)
# for _ in range(N):
#         #문자열 쪼개기
#         word = input().rstrip()
#         new_word = word.split('anta')[1].split('tica')[0]
#         words.append(new_word)
#         cases = cases.union(set(new_word))

# result = 0
# print(words)
# if K < 5:
#     print(0)
# else:
#     cases = list(combinations(cases, K - 5))
#     for case in cases:
#         cnt = 0

#         for word in words:
#             if set(word) <= set(case):
#                 cnt += 1
#         result = max(cnt, result)    
#     print(result)


#백트래킹으로 풀기
from itertools import combinations 
import sys
n, k = map(int, input().split())
answer = 0
# a,n,t,i,c는 반드시 가르쳐야 함

first_word = {'a','n','t','i','c'}

remain_alphabet = set(chr(i) for i in range(97, 123)) - first_word # 남은 알파벳들
data = [sys.stdin.readline().rstrip()[4:-4] for _ in range(n)] # "anta" 와 "tica" 제외해서 입력받기

def countReadableWords(data, learned):
   cnt = 0
   for word in data:
      canRead = 1
      for w in word:
          # 안배웠으니까 못읽는다.
         if learned[ord(w)] == 0:
            canRead = 0
            break
      if canRead == 1:
         cnt += 1
   return cnt

if k >= 5:
   learned = [0] * 123
   for x in first_word: # a n t i c 아는 단어로 처리
      learned[ord(x)] = 1 # 'a' -> ord(97) 

   # 남은 알파벳 중에서 k-5개를 선택해본다.
   for teach in list(combinations(remain_alphabet, k-5)):
      for t in teach: # x, b, y
         learned[ord(t)] = 1
      cnt = countReadableWords(data, learned)

      if cnt > answer:
         answer = cnt
      for t in teach:
         learned[ord(t)] = 0
   print(answer)
else:
   print(0)