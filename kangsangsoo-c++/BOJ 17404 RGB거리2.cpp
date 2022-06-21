#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 1005

ll N;
ll arr[MX][3];
ll dp[MX][3];

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> arr[i][j];
		}
	}

	// 1은 2와 N은 같으면 안된다.
	// N은 N-1, 1과 같으면 안된다.
	// 1과 N은 달라야 한다. => N을 고르때 1을 고려하면 된다.
	
	// i는 i-1과 i+1과 같으면 안된다.
	// 1. 1번 색을 고른다
	// 2. i(1<i<N)는 i-1색과 다르게 고른다.
	// 3. N번 색은 N-1과 1번색을 고려해서 고른다.
	// 4. 1번이 R, G, B 일 때 모두 돌려본다.


	// 0번이 R G B 일 떄 각각
	ll mn = MX * MX * MX;
	for (int z = 0; z < 3; z++) {

		// 초기화
		for (int i = 0; i < MX; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = MX * MX * MX;
			}
		}

		// 0
		dp[0][z] = arr[0][z];

		// 1 ~ N-2
		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == k) continue; // 같은 색은 pass
					dp[i][j] = min(dp[i][j], dp[i - 1][k] + arr[i][j]);
				}
			}
		}

		// N-1
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == z || i == j) continue;
				dp[N - 1][i] = min(dp[N - 1][i], dp[N - 2][j] + arr[N - 1][i]);
			}
		}

		for (int i = 0; i < 3; i++) {
			mn = min(dp[N - 1][i], mn);
		}
	}

	cout << mn;
}
