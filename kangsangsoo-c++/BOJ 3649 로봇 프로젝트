#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef tuple<ll, ll, ll> tlll;
ll x, n;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	while (1) {
		cin >> x >> n;
		if (cin.eof()) break;
		x = x * 10000000;
		vector <ll> arr(n);
		priority_queue <tlll> pq;

		for (ll i = 0; i < n; i++) {
			cin >> arr[i];
		}

		// 정렬
		sort(arr.begin(), arr.end());

		ll l = 0, r = n - 1;
		while (l < r) {
			ll sum = arr[l] + arr[r];

			if (sum == x) pq.push({ arr[r] - arr[l], arr[l], arr[r] });
			if (sum > x) r--; // sum 감소
			else l++; // sum 증가
		}
		if (pq.empty()) cout << "danger\n";
		else {
			ll x, y, z; tie(x, y, z) = pq.top();
			cout << "yes " << y << ' ' << z << '\n';
		}
	}
}
