#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pll;

#define MX 105

ll dy[4] = { 1, -1, 0 ,0 };
ll dx[4] = { 0, 0, 1, -1 };

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	ll N, M;
	ll board[MX][MX];
	ll cheese = 0;

	cin >> N >> M;

	for (ll i = 0; i < N; i++) {
		for (ll j = 0; j < M; j++) {
			cin >> board[i][j];
			if (board[i][j] == 1) cheese++;
		}
	}


	// 1. 외부 공기를 a로 마킹
	// 모눈종이 가장자리는 치즈가 놓이지 않으므로 {0, 0}에서 bfs로 확인 가능

	ll t = 0;

	while (cheese) {
		t--;
		queue <pll> q;
		q.push({ 0, 0 });
		while (!q.empty()) {
			ll x, y; tie(x, y) = q.front(); q.pop();

			for (int i = 0; i < 4; i++) {
				ll nx = x + dx[i];
				ll ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (board[nx][ny] == t || board[nx][ny] == 1) continue;

				board[nx][ny] = t;
				q.push({ nx, ny });
			}
		}

		// 2. 외부 공기에 2이상 닿는 치즈 위치 저장

		vector <pll> melt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != 1) continue;

				ll num = 0;
				for (int k = 0; k < 4; k++) {
					ll nx = i + dx[k];
					ll ny = j + dy[k];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if (board[nx][ny] == t) num++;
				}
				// 외부 공기와 접촉한 면이 2 이상이면
				if (num >= 2) melt.push_back({ i, j });
			}
		}

		// 3. 치즈 녹이기
		for (auto w : melt) {
			board[w.first][w.second] = t;
			cheese--;
		}
	}
	// 4. 치즈가 없어질 때까지 1 ~ 3 반복
	cout << -t;
}
