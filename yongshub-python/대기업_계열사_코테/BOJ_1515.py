import sys
input = sys.stdin.readline
answer = []
temp = input().rstrip()
i = 0

while True:
    i += 1
    num = str(i)
    while len(num) > 0 and len(temp) > 0:
        if num[0] == temp[0]:
            temp = temp[1:]
        num = num[1:]
    if temp == '':
        print(i)
        break