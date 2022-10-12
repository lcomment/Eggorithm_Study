import sys
input = sys.stdin.readline

N = int(input().rstrip())
bits = list(map(int, input().split()))
stu = int(input().rstrip())
students = [tuple(map(int, input().split())) for _ in range(stu)]

for student in students:
    sex, num = student
    if sex == 1:
        for i in range(1, N + 1):
            if i % num == 0:
                if bits[i - 1]:
                    bits[i - 1] = 0
                else: bits[i - 1] = 1
    else:
        num -= 1
        i = 1
        if bits[num]:
            bits[num] = 0
        else: bits[num] = 1
        while True:
            left, right = num - i, num + i
            if left < 0 or left >= N or right < 0 or right >= N:
                break
            if bits[left] == bits[right]:
                if bits[left]:
                    bits[left], bits[right] = 0, 0
                else:
                    bits[left], bits[right] = 1, 1
            else:
                break
            i += 1

if N < 20:
    print(*bits)
else:
    end = 20
    for i in range(0, N, 20):
        print(*bits[i:end])
        end += 20
        if end > N:
            end = N
        

