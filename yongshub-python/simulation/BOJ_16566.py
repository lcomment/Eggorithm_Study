import sys
operators, numbers = dict(), dict()
operators['ADD'], operators['SUB'], operators['MOV'], operators['AND'], operators['OR'], operators['NOT'], operators['MULT'], operators['LSFTL'], operators['LSFTR'], operators['ASFTR'], operators['RL'], operators['RR'] = '00000', '00010', '00100', '00110', '01000', '01010', '01100', '01110','10000', '10010', '10100', '10110'
numbers['0'], numbers['1'], numbers['2'], numbers['3'], numbers['4'], numbers['5'], numbers['6'], numbers['7'] = '0000', '0001', '0010', '0011', '0100', '0101', '0110', '0111'
numbers['8'], numbers['9'], numbers['10'], numbers['11'], numbers['12'], numbers['13'], numbers['14'], numbers['15'] = '1000', '1001', '1010', '1011', '1100', '1101', '1110', '1111'
input = sys.stdin.readline
N = int(input().rstrip())
cases = [list(input().split()) for _ in range(N)]
for case in cases:
    op, result, A, B = case
    try:
        print(f'{operators[op]}0{numbers[result][1:]}{numbers[A][1:]}{numbers[B][1:]}0')
    except:
        mechanicValue = operators[op[:-1]][:-1]
        print(f'{mechanicValue}10{numbers[result][1:]}{numbers[A][1:]}{numbers[B]}')
