#금메달 수가 더 많은 나라
#금메달 수 Equals -> 은메달 수가 더 많은 나라
#금,은메달 모두 같으면 -> 동메달 수가 더 많은 나라
#각 국가는 1 ~ N 사이의 정수 / 한 국가의 등수는 자신보다 더 잘한 나라 수 + 1
#만약 두 나라가 금,은,동 메달 수가 모두 같다면 두 나라의 등수는 같다.

#입력: N(1 ~ 1000), 등수를 알고 싶은 국가 1 <=K<=N 다음 줄 부터 N개의 각 줄에 차례대로 각 국가를 나타내는 정수와 얻은 금, 은, 동 메달수가 빈칸 사이에 두고 주어짐.
#전체 메달 수 : 1000000 이하
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
ranks = 1
cnt = 1
nation_medals = [list(map(int, input().split())) for _ in range(N)]
nation_medals.sort(key=lambda x:(x[1], x[2], x[3]), reverse= True) # x[1] 금메달 순, 금메달이 같다면 x[2] 은메달 순, 은메달이 같다면, x[3] 동메달 순


def validateEqualRanks(original, compare):
    if original[1] != compare[1]:
        return False
    if original[2] != compare[2]:
        return False
    if original[3] != compare[3]:
        return False
    return True


for i in range(N):
    try:
        if nation_medals[i][0] == K:
            print(ranks)
            break
        elif validateEqualRanks(nation_medals[i], nation_medals[i + 1]): #현재 국가와 다음 국가의 금,은,동이 같다면
            cnt += 1
            continue
        else:
            if cnt > 0:
                ranks += cnt
                cnt = 1
            else:
                ranks += 1
    except:
        pass