#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 20

ll N;
ll arr[MX][MX];

// 0: 가로, 1: 세로, 2: 대각선
vector <pll> dy[3] = { {{0, 0}, {0, 1} }, {{1, 1}, {1, 1}}, {{1, 0},{1, 1},{1, 1}} };
vector <pll> dx[3] = { {{1, 1}, {1, 1} }, {{0, 0}, {0, 1}}, {{1, 1},{1, 0},{1, 1}} };
vector <ll> dstate[3] = { {0, 2}, {1, 2}, {0, 1, 2} };
// 체크해야 할 좌표
vector <pll> watch[3] = { {{0, 1}}, {{1, 0}}, {{1, 0}, {0, 1}, {1, 1}} };

ll cnt = 0;

// point: 현재 차지하고 있는 위치
// state: 가로, 세로, 대각선 중 하나
void dfs(pair<pll, pll> point, ll state) {
	// 도착했으면 종료
	if (point.second == make_pair(N, N)) {
		cnt++;
		return;
	}

	pll back = point.first; // 뒤쪽
	pll front = point.second; // 앞쪽

	// 현재 state에 따라서 움직일 수 있는 경우의 수
	for (int i = 0; i < dx[state].size(); i++) {
		pll nback = {back.first + dy[state][i].first, back.second + dx[state][i].first};
		pll nfront = {front.first + dy[state][i].second, front.second + dx[state][i].second};
		ll nstate = dstate[state][i];

		// nstate에 따라서 체크
		int flag = 1;
		for (int j = 0; j < watch[nstate].size(); j++) {
			ll ny = front.first + watch[nstate][j].first;
			ll nx = front.second + watch[nstate][j].second;

			if (nx < 1 || ny < 1 || nx > N || ny > N) flag = 0;
			if (arr[ny][nx] == 1) flag = 0;
		}

		if (flag == 0) continue;

		dfs({ nback, nfront }, nstate);
	}

}


int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	// 입력
	cin >> N;
	for (ll i = 1; i <= N; i++) {
		for (ll j = 1; j <= N; j++) {
			cin >> arr[i][j];
		}
	}

	// dfs
	dfs({{ 1, 1 }, { 1, 2 }}, 0);

	cout << cnt;
}
