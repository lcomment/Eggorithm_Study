#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 105
ll N, M;

char arr[MX][MX];
ll visited[MX][MX];

ll dx[4] = { 0, 0, 1, -1 };
ll dy[4] = { 1, -1, 0, 0};

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	// 입력
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	// 아군 W
	// 적군 B
	ll B_sum = 0;
	ll W_sum = 0;

	// 방문하지 않은 노드에서 bfs
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j] == 0) {
				// bfs
				ll sum = 1;
				queue <pll> q;
				q.push({ i, j });
				visited[i][j] = 1;
				while (!q.empty()) {
					ll x, y; tie(x, y) = q.front(); q.pop();
					
					for (int k = 0; k < 4; k++) {
						ll nx = x + dx[k];
						ll ny = y + dy[k];

						if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
						if (visited[nx][ny] == 1 || arr[i][j] != arr[nx][ny]) continue;

						visited[nx][ny] = 1;
						q.push({ nx, ny });
						sum++;
					}
				}

				// += N^2
				if (arr[i][j] == 'W') W_sum += sum * sum;
				else B_sum += sum * sum;
			}
		}
	}

	// 답 출력
	cout << W_sum << ' ' << B_sum;
}
