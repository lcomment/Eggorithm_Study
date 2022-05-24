import sys
input = sys.stdin.readline
# 접시 수, 가짓수, 연속해서 먹는 수, 쿠본 번호
N, d, k, c = map(int, input().split())
sushi = []
# 벨트 초기화
for _ in range(N):
    sushi.append(int(input().rstrip()))

# 연속해서 먹는 접시의 수 k 경우의 수 구하기
result = 0
for i in range(N):
    end = i  # 처음 가리키는 end 인덱스
    cnt = 0
    case = set()
    while cnt < k:  # cnt가 k보다 작을 때
        case.add(sushi[end % N])
        end += 1
        cnt += 1
    case.add(c)
    result = max(result, len(case))
print(result)
# 원형 큐로 생각해야한다!
