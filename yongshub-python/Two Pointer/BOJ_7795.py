import sys
input = sys.stdin.readline

N = int(input().rstrip())


for _ in range(N):
    A, B = map(int, input().split())
    datas_A = list(map(int, input().split()))  # 테스트 케이스 A
    datas_B = list(map(int, input().split()))  # 테스트 케이스 B
    datas_A.sort()  # datas_A 정렬
    datas_B.sort()  # datas_B 정렬

    start, end = 0, 0
    count = 0
    cnt = 0
    for i in range(A):
        # end가 datas_B의 길이보다 작고 값이 A보다 작다면
        while end < B and datas_B[end] < datas_A[i]:
            end += 1  # end 인덱스 + 1
            cnt += 1  # 개수 + 1
        count += cnt

    print(count)
