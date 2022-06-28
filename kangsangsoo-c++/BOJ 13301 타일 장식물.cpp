#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 85

ll dp[MX];
ll N;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	cin >> N;

	dp[1] = 1;
	dp[2] = 1;

	for (int i = 3; i <= N; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}

	cout << dp[N] * 2 + (dp[N-1] + dp[N]) * 2;
	
}
