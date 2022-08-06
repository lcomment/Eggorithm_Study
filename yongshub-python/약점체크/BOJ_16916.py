# 28%에서 시간초과
# import sys
# input = sys.stdin.readline


# S = input().rstrip()
# P = input().rstrip()


# def findValue():
#     p_length = len(P)
#     s_length = len(S)
#     start, end = 0, 0
#     for _ in S:
#         # start지점이 P[0]과 같다면
#         if S[start] == P[0]:
#             #시작 요소가 P문자열 길이보다 짧다면
#             if s_length - start < p_length:
#                 return 0
#             end = start + 1
#             new_start = (0, False)
#             isCheck = True
#             for j in range(1, p_length):
#                 #진행 도중에 P[0]이 또 존재한다면
#                 if new_start[1] is False and S[end] == P[0]:
#                     new_start = (end, True)
#                 #다른 단어가 존재한다면
#                 if S[end] != P[j]:
#                     isCheck = False
#                     break
#                 end += 1
#             if isCheck:
#                 return 1
#             else:
#                 if new_start[1]:
#                     start = new_start[0]
#                 else: start += 1
#         else:
#             start += 1
#     return 0


# result = findValue()
# print(result)

# rabin_karp
# import sys
# input = sys.stdin.readline
# S = input().rstrip()
# P = input().rstrip()

# def rabin_karp(S, P):
#     n = len(S)
#     m = len(P)
#     Shash, Phash, base = 0, 0, 1;

#     for i in range(m - 1, -1, -1):
#         Shash = Shash + ord(S[i]) * base
#         Phash = Phash + ord(P[i]) * base

#         if i > 0:
#             base *= 2
#     Shash = Shash % 131
#     Phash = Phash % 131
#     for i in range(0, n - m + 1):
#         if i > 0:
#             Shash = ((Shash * 131 - ord(S[i - 1]) * base) * 2 + ord(S[m - 1 + i])) % 131

#         if(Phash == Shash):
#             isFind = True
#             for j in range(m):
#                 if S[i + j] != P[j]:
#                     isFind = False
#                     break
#             if isFind:
#                 return True
#     return False


# result = rabin_karp(S, P)
# if result:
#     print(1)
# else:
#     print(0)
import sys
input = sys.stdin.readline

def kmp(pat, txt):
    N = len(txt)
    M = len(pat)
    lps = [0] * M
    compute_lps(pat, lps)
    
    i = 0 # index of txt
    j = 0 # index of pat
    while i < N:
        if pat[j] == txt[i]:
            if j == M - 1:
                return True
            else:
                i += 1
                j += 1
        else:
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1
        if j == M:
            return True
            # 이 문제에서는 일치하는게 있는지만 검사
        

def compute_lps(pat, lps):
    leng = 0
    i = 1
    while i < len(pat):
        if pat[i] == pat[leng]:
            leng += 1
            lps[i] = leng
            i += 1
        else:
            if leng != 0:
                leng = lps[leng - 1]
            else:
                lps[i] = 0
                i += 1
                
if __name__ == "__main__":
    txt = input().strip()
    pat = input().strip()
    if kmp(pat, txt):
        print(1)
    else:
        print(0)