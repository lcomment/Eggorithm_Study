import sys
input = sys.stdin.readline

inputs = list(input().split())
type = inputs[0]
inputs[-1] = inputs[-1].split(';')[0]

#변수명은 한글자 이상이 될 수 있음.
for declar in inputs[1:]:
    alphabet = ''
    extra = ''
    new_type = type[:]
    for i in range(len(declar)):
        if 65 <= ord(declar[i]) <= 90 or 97 <= ord(declar[i]) <= 122:
            alphabet += declar[i]
        else:
            extra = declar[i:]
            break
    extra = extra.split(',')[0]
    for i in extra[-1::-1]:
        if i == ']':
            new_type += '[]'
        elif i == '[':
            continue
        else:
            new_type += i
    print(f'{new_type} {alphabet};')