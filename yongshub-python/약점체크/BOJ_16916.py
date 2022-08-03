import sys
input = sys.stdin.readline
S = input().rstrip()
P = input().rstrip()
check = False

def dfs(check, idx):
    for i, v in zip(S[idx:], P):
        if i != v:
            return False
    if len(S[idx:]) < len(P):
        return False
    return True


for idx, alphabet in enumerate(S):
    if alphabet == P[0]:
        check = dfs(check, idx)
        if check:
            print(1)
            break

if not check:
    print(0)
                
# 시간초과난다.