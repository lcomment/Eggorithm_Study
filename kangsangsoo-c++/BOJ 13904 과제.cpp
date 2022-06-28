#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 1005
ll N;
ll d, w;

ll used[MX];

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> N;

	priority_queue <pll> pq; // heap

	for (ll i = 0; i < N; i++) {
		cin >> d >> w;
		pq.push({ w, -d }); // 가중치는 높게, 날짜는 빠르게
	}

	ll ans = 0;

	while (!pq.empty()) {
		ll p, dd; tie(p, dd) = pq.top(); pq.pop();
		// 원래 마감일과 가깝게 설정
		for (ll i = -dd; i > 0; i--) {
			if (used[i] == 0) { 
				used[i] = 1;
				ans += p;
				break;
			}
		}
	}

	cout << ans;

}
