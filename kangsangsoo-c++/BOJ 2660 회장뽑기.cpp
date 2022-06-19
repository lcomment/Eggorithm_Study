#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 55

vector <ll> v[MX];
ll ans[MX];
ll N;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	// 입력
	cin >> N;
	ll a, b;
	while (1) {
		cin >> a >> b;
		if (a == -1 && b == -1) break;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	
	// 모든 점에 대해서 bfs를 하고 visited의 최댓값을 찾는다.
	for (ll i = 1; i <= N; i++) {
		// visited -1로 초기화
		ll visited[MX];
		for (ll j = 0; j < MX; j++) visited[j] = -1;

		// bfs 시작
		visited[i] = 0;
		queue <ll> q;
		q.push({ i });
		while (!q.empty()) {
			ll cur = q.front(); q.pop();
			for (auto j : v[cur]) {
				if (visited[j] == -1) {
					visited[j] = visited[cur] + 1;
					q.push(j);
				}
			}
		}

		// 최댓값 찾기
		for (ll j = 1; j <= N; j++) {
			ans[i] = max(ans[i], visited[j]);
		}
	}

	// 정답 찾기
	ll mn = 100;
	for (ll i = 1; i <= N; i++) {
		mn = min(ans[i], mn);
	}
	vector <ll> list;
	for (ll i = 1; i <= N; i++) {
		if (ans[i] == mn) list.push_back(i);
	}
	cout << mn << ' ' << list.size() << '\n';
	for (auto i : list) {
		cout << i << ' ';
	}
}
