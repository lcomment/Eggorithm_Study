# 01.10 알고리즘 문제풀이

## 🔍 진행 방식

### BOJ_20006 랭킹전 대기열

- 문제를 읽고, 자료구조로 간단히 풀 수 있는 문제 같았지만 생각보다 쉽게 풀리지 않았다.
- 객체에 대한 이해과 어느 정도 있다면 풀 수 있는 문제 같았고,
- 클래스의 필드를 Collections.sort()로 정렬하는데, 정렬할 클래스의 필드를 id 사전순으로 해주어야 하기에 Comparable<User>을 implements했다.

### BOJ_11052 카드 구매하기

- 문제를 읽고, 재귀함수로 풀면 되지 않을까 하는 생각에 이대로 시도해보았다.
- 여러 반례에 맞지 않는 답이나와 힌트를 보니 dp문제였다. top-bottom, bottom-up 모두 가능했고
- 오랜만에 dp를 접해서 적용하는데 어려웠다. (개인적으로 top-bottom이 bottom-up보다 더 어려운 것 같다.)

### BOJ_7569 토마토

- 문제를 읽고, 값의 범위와 최단 시간을 구하는 문제인 것을 보고 BFS를 사용하면 편할것이라 생각했다.
- 어려웠던 것은 3차원 구조에서 높이가 다른 부분의 인접한 부분 확장 이었는데 생소해서 좀 더 어렵게 다가왔던 것 같다.
- 이 문제를 확인 후 다른 토마토 문제를 보았는데 그것은 2차원 구조의 BFS를 적용하는거 같아 문제 풀이 순서가 아쉬웠다!


### BOJ_7576 토마토

- 문제를 읽고, 값의 범위와 최단 시간을 구하는 문제인 것을 보고 BFS를 사용하면 편할것이라 생각했다.
- 헤깔렸던 부분은 col 과 row로 배열지정 이었다.
- BFS 기본문제라고 생각되고 연습하기 좋았던 문제같다.



==============================================================





### BOJ_1260 DFS 와 BFS

- 문제를 읽고, DFS와 BFS구현을 위해 생각했다.
- DFS는 재귀로 BFS는 큐를 이용했고, 인접행렬에 데이터를 넣어 풀어보았다.
- 문제를 스스로 해결하지는 못했지만 좋은 이해를 한 것 같다.


### BOJ_24416 알고리즘 수업 - 피보나치 수 1

- 재귀 함수와 DP의 동작 횟수 차이 확인하는 문제

### BOJ_1904 01타일

- DP 기본 문제이고, 잘못 생각했던 곳은 
- 1) 전부 더한 다음 그 값의 결과를 받아 %15746 할려 했는데, 값이 범위를 넘어설 수 있었고
- 2) (A+B)%C = (A%C + B%C)%C 모듈러 연산의 분배법칙이었다.

### BOJ_2178 미로

- BFS 기본문제이고, 해당 지점까지 최단거리 값을 구하는 문제였다.
- 이 문제가 BFS에 더 유리하다고 이해한것은 블로그를 참고 후 알았다. BFS의 원리로 해당 지점까지 먼저 도착한 것의 값이 저장되기 때문
- 개념을 이해하는데 좋은 문제였다고 생각한다.

### BOJ_2178 미로

- BFS 기본문제이고, 해당 지점까지 최단거리 값을 구하는 문제였다.
- 이 문제가 BFS에 더 유리하다고 이해한것은 블로그를 참고 후 알았다. BFS의 원리로 해당 지점까지 먼저 도착한 것의 값이 저장되기 때문
- 개념을 이해하는데 좋은 문제였다고 생각한다.

### BOJ_2156 포도주 시식

- 문제를 봤을 때 재귀나 Dp로 해결하면 좋을거 같다는 느낌을 받았고,
- 식을 구성하는데 생각보다 어려웠다. 3개의 연속되지 않는 값에서 3번의 비교를 통해 dp[i]값을 구해야 했다.
