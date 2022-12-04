# 11.29 알고리즘 문제풀이

## 🔍 진행 방식

### 19637_IF문 좀 대신 써줘

- 첫번째 풀이 : HashMap을 이용하여 등급과 값을 저장하고, 해당 데이터를 비교 - 시간초과오류
- 두번째 풀이 : 정렬되어있는 값과 범위를 통해 이분탐색을 사용하여 다시 적용하였지만, 아래 이유로 오류 수정


```
answer.add(gradeName[left]); -> );
answer.forEach(System.out::println);

         ||
         ||
                
bw.write(gradeName[left]+"\n");
bw.flush();

*입력 뿐 아니라 출력이 많을 때도 시간이 오래 걸린다는 점에서 BufferWriter도 사용할 줄 알아야했다.
```

```
추가로 

Arrays.sort : 퀵 정렬 / 최악일 경우 O(n^2) 이지만,
Collections.sort() : Timsort - Timsort란 삽입 정렬과 합병정렬을 결합하여 만든 정렬 / 최악일 경우 O(nlog(n)) 

시간 복잡도가 다른것은 알고 있었지만 조금 자세하게 나와있어 자바를 공부하는 친구들을 위해 넣어놓았다. 궁금하면 아래 링크로 가서 읽어봐도 재밌을거다.
https://laugh4mile.tistory.com/175
```
