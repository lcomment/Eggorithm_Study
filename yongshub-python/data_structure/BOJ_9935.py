import sys
input = sys.stdin.readline
inputs = input().rstrip()
bomb = input().rstrip()
length = len(bomb)
stack = []
lastChar = bomb[-1]

for char in inputs:  # mirkovC4nizCC44
    stack.append(char)
    if char == lastChar and ''.join(stack[-length:]) == bomb:
        del stack[-length:]

answer = ''.join(stack)
if answer == '':
    print('FRULA')
else:
    print(answer)

a = [1, 2, 3, 4, 5]
a[1:3] = [2, 3]
a[-3:] = [3, 4, 5]
stack = [1, 2, 3, 4, 5]
# -> 시간 초과 코드
# while True:
#     if bomb not in inputs:
#         break
#     for i in range(len(inputs)):
#         if i + length <= len(inputs) and inputs[i: i + length] == bomb:
#             inputs = inputs.replace(bomb, "")

# if len(inputs) == 0:
#     print('FRULA')
# else:
#     print(inputs)


# -> 시간 초과 코드
# def deleteBomb(inputs, cnt):
#     result = inputs.replace(bomb, "", cnt)  # inputs에서 bomb문자열 cnt만큼 제거
#     return result


# while True:
#     cnt = inputs.count(bomb)
#     if cnt == 0:  # 문자열에 bomb 없다면 break
#         break
#     inputs = deleteBomb(inputs, cnt)


# if len(inputs) == 0:
#     print('FRULA')
# else:
#     print(inputs)
