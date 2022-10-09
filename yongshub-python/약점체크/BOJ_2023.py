import sys
input = sys.stdin.readline
N = int(input().rstrip())

def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


def dfs(n):
    global N
    if len(str(n)) == N:
        print(n)
    else:
        n = n * 10
        for i in range(1, 10):
            if isPrime(n + i):
                dfs(n + i)


dfs(2)
dfs(3)
dfs(5)
dfs(7)