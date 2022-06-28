#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

# define MX 105

ll dp[MX]; 
ll item[MX]; // 뱀 또는 사다리 저장
ll N, M;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	cin >> N >> M;

	for (ll i = 0; i < N + M; i++) {
		ll a, b;
		cin >> a >> b;
		item[a] = b;
	}

	for (ll i = 0; i < MX; i++) dp[i] = MX;

	queue <ll> q;
	dp[1] = 0;
	q.push(1);

	while (!q.empty()) {
		ll x = q.front(); q.pop();

		for (ll i = 1; i <= 6; i++) {
			ll nx = x + i;

			if (nx > 100) continue;

			if (dp[nx] > dp[x] + 1) {
				dp[nx] = dp[x] + 1;

				// 뱀 또는 사다리가 있으면 이동
				if (item[nx] != 0) {
					if (dp[item[nx]] > dp[nx]) {
						dp[item[nx]] = dp[nx];
						q.push(item[nx]);
					}
				}
				else {
					q.push(nx);
				}
			}
		}
	}

	cout << dp[100];
}
