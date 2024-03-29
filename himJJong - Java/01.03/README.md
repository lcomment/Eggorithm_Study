# 01.03 알고리즘 문제풀이

## 🔍 진행 방식

### BOJ_2164 카드2

- 문제를 읽고 컬렉션을 활용하여 동적 배열을 이용한다면 쉽게 풀 수 있겠다고 생각이 들었고
- while문을 통해 리스트의 사이즈가 1일때 까지
- 한번은 맨 위에서 제거, 한번은 맨 위 값을 맨 아래에 추가 삽입하여 해결했다
- 
### BOJ_20922 겹치는건 싫어

- 문제를 읽었을 때 data값의 배열과 check 해주기 위한 배열로, 범위 내의 값에 있을 때마다 최댓값을 구하도록 해결했다. 
- 그것이 주석처리한 아래 코드인데, 문제에 주어져 있던 다른 테케를 통과함에도 시간초과가 났다 이유는 O(N^2)이라
- 그래서 아래의 알고리즘 종류를 확인해보니 투 포인터 문제였고, start와 end를 두어 O(N)으로 해결했다


### BOJ_13144 List of Unique Numbers

- 문제를 읽었을 때 연속된 수를 겹치는거 없도록 체크해줘야 하므로 이를 위해 check 배열을 만들었다.
- 한 번의 체크로 start와 end를 확인해가며 start-end+1을 통해 구하는 것이 핵심이었던 것 같다.
- 잘못된 생각의 흐름은 아래와 같다.

```
< 메인 로직만 > 
첫번째 시도 (시간초과)

while(start != num) {
     while (end <= data.length-1 && check[data[end]] == 0) {
            check[data[end]]++;
            end++;
            answer++;
        }
        Arrays.fill(check, 0);
        start++;
        end = start;
}

위는 1 2 3 1 2 가 있다면 start와 end 모두를
1) 1부터 시작해서 겹치는게 없을 때까지 answer++
2) 다시 2부터 시작해서 겹치는게 없을 때까지 answer++

이렇게 해서 끝까지 돌아가는 식이었다. 결국 O(N^2)

=========================================================

두 번째 시도 (메모리 초과 && 시간초과)

while(start != num) {
     int[] check = new int[max+1];
     while (end <= data.length-1 && check[data[end]] == 0) {
          check[data[end]]++;
          end++;
          answer++;
     }
     start++;
     end = start;
}

로직이 잘못된것을 인지 못하고, Arrays.fill의 시간복잡도 때문에 생긴 문제가 아닐까 생각들어서
while문을 돌때마다 배열을 다시 초기화 해줬는데 잘못된 방법이었다.
     
```
### BOJ_13144 공유기 설치

- 문제를 읽었을 때 x좌표의 값이 10억 인 것을 확인했고, 정렬하여 차례로 데이터를 확인하면 될 것 같아 이진탐색이 적당하다 생각됐다.
- 시간을 많이 쓴 곳은 문제에 대한 이해였는데, C개의 공유기를 최대로 설치하면서 거리의 최댓값을 구하는 문제였다.
- 여기서 중요하다고 느꼈던 부분은, 제일 왼쪽에 값을 설정해두기와 공유기 설치한 부분을 기점으로 거리를 계산해주는 것이라고 생각된다.

### BOJ_20920 영단어 암기는 괴로워

- 처음 문제를 읽었을 때 구현 같았다. 나와있는 영단어 약속대로 구현을 하면 된다고 생각했고
- 그대로 구현을 했었는데, 시간초과가 자주 일어났다. 뭔가 다르게 푸는 방법이 있을까 해서 참고해보았는데,
- 내가 모르고 있던 람다식을 활용하여 sort해주는 방식이 있었고, 이를 통해 해결하게 되었다.
- BOJ_20920 클래스의 아래 주석 코드는 처음에 작성한 코드이며, 시간초과가 나서 위처럼 변경하였다.

```
추가로

자바 11버전과 17버전의 차이로

1) 어떤 코드는 BufferWriter로 되는 경우가 있는 반면 시간초과가 날때도 있었으며,
2) StringBuilder를 썼을 땐 시간초과 없이 전부 잘 돌아갔었다.
3) 17에서는 import java.util.*; 로 오른쪽 Collections를 추가하지 않아도 컴파일 오류가 없었는데
   백준 자바11 에서는 오른쪽이 추가되지 않으면 컴파일 오류가 발생했다. -> import java.util.stream.Collectors; 
```