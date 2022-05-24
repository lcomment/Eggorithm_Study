import sys
input = sys.stdin.readline

while True:
    try:
        result = False
        a, b = 0, 0
        width = int(input().rstrip()) * (10 ** 7)
        N = int(input().rstrip())
        testCase = []
        for _ in range(N):  # 테스트 케이스 입력
            testCase.append(int(input().rstrip()))
        testCase.sort()  # 정렬
        i, j = 0, N - 1
        while i < j:
            if testCase[i] + testCase[j] == width:  # 절대값이  최대값일 수 밖에 없다.
                result = True
                print('yes', testCase[i], testCase[j])
                break
            elif testCase[i] + testCase[j] > width:
                j -= 1
            else:
                i += 1

        if result is False:
            print('danger')
    except:
        break
