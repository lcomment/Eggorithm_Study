#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 255

ll R, C, v, k;

char arr[MX][MX];
ll visited[MX][MX];
ll dx[4] = { 0, 0, 1, -1 };
ll dy[4] = { 1, -1, 0, 0 };

void bfs(ll a, ll b) {
	queue <pll> q;
	visited[a][b] = 1;
	q.push({ a, b });

	ll cv = 0, ck = 0;
	while (!q.empty()) {
		ll x, y; tie(x, y) = q.front(); q.pop();

		for (int i = 0; i < 4; i++) {
			ll nx = x + dx[i];
			ll ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			if (visited[nx][ny] == 1 || arr[nx][ny] == '#') continue;
			
			q.push({ nx, ny });
			visited[nx][ny] = 1;
			if (arr[nx][ny] == 'v') cv++; // 늑대의 수
			if (arr[nx][ny] == 'k') ck++; // 양의 수
		}
	}

	// 늑대가 같거나 많으면 양 감소
	if (cv >= ck) k -= ck;
	// 양이 더 많으면 늑대 감소
	else v -= cv;
}

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	cin >> R >> C;

	for (ll i = 0; i < R; i++) {
		for (ll j = 0; j < C; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 'v') v++;
			if (arr[i][j] == 'k') k++;
		}
	}

	// . 빈 공간
	// # 울타리
	// v 늑대
	// k 양

	for (ll i = 0; i < R; i++) {
		for (ll j = 0; j < C; j++) {
			// 아직 방문안했으면
			if (visited[i][j] == 0 && arr[i][j] != '#') {
				bfs(i, j);
			}
		}
	}
	cout << k << ' ' << v;


}
