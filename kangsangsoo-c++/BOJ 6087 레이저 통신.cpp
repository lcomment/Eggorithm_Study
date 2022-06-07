#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 105

char arr[MX][MX];
ll visited[4][MX][MX];
ll H, W;
ll dx[4] = { 1, 0, 0, -1 };
ll dy[4] = { 0, 1, -1, 0 };

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	// 입력
	cin >> W >> H;
	vector <pll> start;
	for (ll i = 0; i < H; i++) {
		for (ll j = 0; j < W; j++) {
			cin >> arr[i][j];
			// 'C'를 찾으면 좌표 저장
			if (arr[i][j] == 'C') start.push_back({ i, j });
			// visited를 큰 값으로 초기화
			for(int k = 0; k < 4; k++) visited[k][i][j] = 100000;
		}
	}
	//


	// bfs하는데 방향 꺽을 때마다 + 1 
	// {이전 방향, x좌표, y좌표}
	queue <tlll> q;

	// 시작
	for(int i = 0; i < 4; i++) visited[i][start[0].first][start[0].second] = 0;
	q.push({ 0, start[0].first, start[0].second });
	q.push({ 1, start[0].first, start[0].second });
	q.push({ 2, start[0].first, start[0].second });
	q.push({ 3, start[0].first, start[0].second });

	while (!q.empty()) {
		ll z, x, y; tie(z, x, y) = q.front(); q.pop();
		for (ll i = 0; i < 4; i++) {
			ll nx = x + dx[i];
			ll ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
			if (arr[nx][ny] == '*') continue;

			// 다음 방문할 곳에지금까지 거울 사용한 개수
			ll res;
			// 같은 방향
			if (z == i) res = visited[z][x][y];
			// 다른 방향이면 거울 1개 추가하므로 +1
			else res = visited[z][x][y] + 1;

			// 더 작은 값이 나오면 갱신
			if (visited[i][nx][ny] > res) {
				visited[i][nx][ny] = res;
				q.push({ i, nx, ny });
			}
		}
	}

	// 4방향 중 최소 찾기
	ll mn = 100000;
	for (int i = 0; i < 4; i++) mn = min(mn, visited[i][start[1].first][start[1].second]);

	cout << mn;
	
}
