#이제 우리가 할 일은 다음과 같다. 원장 선생님께서 N가지 종류의 동전을 각각 몇 개씩 주셨을 때, 그 돈을 반으로 나눌 수 있는지 없는지 판단하는 것이다.
# 세 개의 입력이 주어진다. 
# 각 입력의 첫째 줄에 동전의 종류 N(1 ≤ N ≤ 100)이 주어진다. 
# 각 입력의 둘째 줄부터 N+1째 줄까지 각각의 동전의 금액과 개수가 빈 칸을 사이에 두고 주어진다. 
# 단, 원장선생님께서 주신 금액의 총 합은 100,000원을 넘지 않는다. 동전의 금액과 개수는 자연수이고, 같은 금액을 가진 동전이 두 번 이상 주어지는 경우는 없다.

#출력
#첫째 줄부터 세 줄에 걸쳐, 각 입력에 대하여 반으로 나누는 것이 가능하면 1, 불가능하면 0을 출력한다.

# 2
# 500 1
# 50 1
# 3
# 100 2
# 50 1
# 10 5
# 3
# 1 1
# 2 1
# 3 1

# 0
# 1
# 1
import sys
from itertools import combinations

input = sys.stdin.readline

for _ in range(3):
    N = int(input().rstrip())
    coins = []
    for _ in range(N):
        money, cnt = map(int, input().split())
        coins.extend([money] * cnt)
    
    total_money = sum(coins)
    half_money = total_money // 2

    for i in range(1, N):
        check = False
        for comb in combinations(coins, i):
            if sum(comb) == half_money:
                check = True
                break
        if check:
            print(1)
            break
        else:
            print(0)
            break
    

