#include <bits/stdc++.h>
using namespace std;

ll W[15][15];
ll visited[15];
ll N;
ll ans = 100000000;

// num: 방문한 노드 개수
// nxt: 방문한 노드 번호
// sum: 현재까지 방문하는데 필요한 비용
void func(ll num, ll nxt, ll sum) {
  // 노드 개수가 N-1개이면
  // 출발지로 다시 돌아와야하기 때문에
  // 현재 nxt 노드에서 출발 노드 1로 돌아간다.
	if (num == N-1) {
		if (W[nxt][1] == 0) return;
		ans = min(ans, sum + W[nxt][1]);
		return;
	}

  // 방문 표시
	visited[nxt] = 1;
	for (int i = 1; i <= N; i++) {
    // 이미 방문했거나 길이 없으면 못간다.
		if (nxt == i || visited[i] == 1 || W[nxt][i] == 0) continue;

    // 방문한 노드 개수 +1, 다음 방문 노드 i, 현재 비용에 추가로 더해서 ㄱ
		func(num + 1, i, sum + W[nxt][i]);
	}
  // 방문 해제
	visited[nxt] = 0;

}

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	// 입력
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> W[i][j];
		}
	}

	// i -> j
	func(0, 1, 0);
	cout << ans;
}
