#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pll;

#define MX 15

ll dy[4] = { 1, -1, 0 ,0 };
ll dx[4] = { 0, 0, 1, -1 };

ll p[MX];
vector <ll> v[MX];

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	ll N;

	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> p[i];
	}

	for (int i = 1; i <= N; i++) {
		ll a, b;
		cin >> a;
		for (int j = 0; j < a; j++) {
			cin >> b;
			v[i].push_back(b);
		}
	}

	int num = 0;
	int a[MX] = { 0 };
	ll visited[MX];
	memset(visited, 0, MX * sizeof(ll));


  // 그래프가 몇 개로 나누어지는지 bfs로 확인
	for (int i = 1; i <= N; i++) {
		if (visited[i] == 0) {
			visited[i] = 1;
			a[num] += p[i];
			queue <ll> q;
			q.push(i);
			while (!q.empty()) {
				int cur = q.front(); q.pop();

				for (auto j : v[cur]) {
					if (visited[j] == 0) {
						visited[j] = 1;
						a[num] += p[j];
						q.push(j);
					}
				}
			}
			num++;
		}
	}

	// 그래프가 3개 이상으로 분리되면 선거구로 나눌 수 없다.
	if (num > 2) cout << -1;
	// 그래프가 2개로 분리되면 답은 정해져 있다.
	else if (num == 2) cout << abs(a[0] - a[1]);
	// 그래프가 1개로 연결되어 있으면 완전탐색을 한다.
	else {
		// N을 비트마스킹해서 0, 1로 2개의 집합으로 분리할 수 있음.
		ll mn = 10000000000;
		for (int i = 1; i < (1 << N) - 2; i++) {
			ll visited[MX];
			memset(visited, 0, sizeof(ll) * MX);
			
			ll s[MX];
			ll start[2];
			for (int j = 1; j <= N; j++) {
				s[j] = (i >> (j - 1)) & 1; // 0번 집합인지, 1번 집합인지
				if (s[j] == 1) start[1] = j;
				if (s[j] == 0) start[0] = j;
			}

			ll sum[2] = { 0 };
			ll cnt[2] = { 0 };

      // 0번 집합의 임의의 점에서 bfs했을 때 
			// 0번 집합의 원소를 모두 방문할 수 있어야 한다.
			visited[start[0]] = 1;
			queue <ll> q;
			q.push(start[0]);
			sum[0] += p[start[0]];
			cnt[0]++;
			while (!q.empty()) {
				int cur = q.front(); q.pop();
				for (auto j : v[cur]) {
					if (visited[j] == 0 && s[j] == 0) {
						visited[j] = 1;
						q.push(j);
						cnt[0]++;
						sum[0] += p[j];
					}
				}
			}

      // 1번 집합의 임의의 점에서 bfs했을 때 
			// 1번 집합의 원소를 모두 방문할 수 있어야 한다.
			visited[start[1]] = 1;
			q.push(start[1]);
			sum[1] += p[start[1]];
			cnt[1]++;
			while (!q.empty()) {
				int cur = q.front(); q.pop();
				for (auto j : v[cur]) {
					if (visited[j] == 0 && s[j] == 1) {
						visited[j] = 1;

						q.push(j);
						cnt[1]++;
						sum[1] += p[j];
					}
				}
			}

      // 선거구 쪼갬이 유효한지 확인
			// 0번 집합의 임의의 원소에서 bfs해서 방문한 노드의 개수
			// +
			// 1번 집합의 임의의 원소에서 bfs해서 방문한 노드의 개수
			// 는 N이면 가능
			if (cnt[0] + cnt[1] == N) {
				mn = min(mn, abs(sum[0] - sum[1]));
			}
		}
		cout << mn;
	}

}
