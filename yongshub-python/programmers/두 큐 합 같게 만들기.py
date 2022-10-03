from collections import deque
def solution(queue1, queue2):
    answer = 0
    queue1, queue2 = deque(queue1), deque(queue2)
    sum_1 = sum(queue1)
    sum_2 = sum(queue2)
    for i in range(len(queue1) * 3):
        if sum_1 < sum_2:
            sum_2 -= queue2[0]
            sum_1 += queue2[0]
            queue1.append(queue2.popleft())
        elif sum_1 > sum_2:
            sum_1 -= queue1[0]
            sum_2 += queue1[0]
            queue2.append(queue1.popleft())
        else:
            return answer
        answer += 1
    return -1