# K개의 문제를 풀게됨. 0 ~ 100점을 얻게됨. 팀의 ID/문제 번호/점수 서버에 올라가고 로그에 제출되는 시간 순서대로 저장
# 한 문제에 대해 풀이를 여러번 제출할 수 있는데 최고 점수가 문제에 대한 최종 점수가 된다. (한번도 제출하지 않았으면 문제에 대한 최종 점수는 0점)
# 팀의 최종점수는 각 문제에 대해 받은 점수의 총합/ 순위는 팀보다 높은 점수를 받은 팀의 수 + 1
# 점수가 동일한 팀이 여럿 있다면
# 1. 최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높음.
# 2. 최종 점수도 같고 제출 횟수도 같은 경우 마지막 제출 시간이 더 빠른 팀의 순위가 높음.
# T개의 테스트 데이터로 구성
import sys
input = sys.stdin.readline
T = int(input().rstrip())
for _ in range(T):
    n, k, t, m = map(int, input().split()) # 팀 개수 n, 문제의 개수 k, 팀의 id t, 로그 엔트리 개수 m
    scores = dict()
    time = [0] * (n + 1)
    for i in range(1, n + 1):
        for j in range(1, k + 1):
            scores[(i, j)] = (0, 0) # (i: 팀id, j: 문제번호) = (점수, 제출횟수)
    for k in range(m):
        i, j, s = map(int, input().split()) # 팀 ID i, 문제번호 j, 획득한 점수 s
        score, cnt = scores[(i, j)]
        score = max(score, s)
        cnt += 1
        scores[(i, j)] = (score, cnt)
        time[i] = k
    #최종 점수와 제출 횟수 구하기
    total_score = [(0, 0, 0, 0)] * (n + 1) #최종 점수, 제출 횟수, 로그
    for id, number in scores.keys():
        prev_score, prev_cnt, log_order, prev_id = total_score[id]
        prev_score += scores[(id, number)][0]
        prev_cnt += scores[(id, number)][1]
        log_order = time[id]
        total_score[id] = (prev_score, prev_cnt, log_order, id)
    total_score.sort(key=lambda x: (x[0], -x[1], -x[2]), reverse=True)
    for idx, result in enumerate(total_score):
        if result[3] == t:
            print(idx + 1)
            break