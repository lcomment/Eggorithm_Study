# 여섯 명의 선수로 구성되며, 팀 점수는 상위 네 명의 주자의 점수를 합하여 계산
# 이 점수를 더하여 가장 낮은 점수를 얻는 팀이 우승을 하게 된다. 여섯 명의 주자가 참가하지 못한 팀은 점수 계산에서 제외된다

#입력은 T 개의 테스트 케이스
# 첫 번째 줄에 테스트 케이스의 수를 나타내는 정수 T 
#각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N (6 ≤ N ≤ 1,000)이 주어진다. 
# 두 번째 줄에는 팀 번호를 나타내는 N 개의 정수 t1, t2, …, tN 이 공백을 사이에 두고 주어진다. 각 팀은 1 과 M(1 ≤ M ≤ 200)사이의 정수로 표현된다.
import sys
from collections import defaultdict
from collections import deque
input = sys.stdin.readline

T = int(input().rstrip())

def getParticipantsCount(team_numbers, team_number, visited):
    if team_numbers.count(team_number) == 6:
        team_ranks[team_number]
        visited[team_number] = True


def setDictionary(team_numbers):
    visited = defaultdict(bool)
    for team_number in team_numbers:
        if not visited[team_number]:
            getParticipantsCount(team_numbers, team_number, visited)


def setScoresByTeam(team_numbers):
    scores = deque([i for i in range(1, N + 1)])
    for idx, team_number in enumerate(team_numbers):
        if team_number in team_ranks.keys():
            team_ranks[team_number].append(scores[idx])
        else:
            scores.rotate(1)


def getWinner():
    stack = [(0,6000)]
    for candidate in team_ranks:
        result = sum(team_ranks[candidate][:4])
        if result < stack[-1][1]:
            stack.pop()
            stack.append((candidate, result))
        elif result == stack[-1][1]:
            if sum(team_ranks[candidate][:5]) < sum(team_ranks[stack[-1][0]][:5]):
                stack.pop()
                stack.append((candidate, result))

    return stack[-1][0]


for _ in range(T):
    team_ranks = defaultdict(list)
    N = int(input().rstrip())
    team_numbers = list(map(int, input().split()))
    setDictionary(team_numbers)
    #setScore
    setScoresByTeam(team_numbers)
    winner = getWinner()
    print(winner)
    
    
    
