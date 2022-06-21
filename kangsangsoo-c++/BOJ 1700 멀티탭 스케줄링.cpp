#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 105

ll N, K; 
ll arr[MX]; // 전기용품 순서
ll plug[MX]; // 1이면 콘센트에 꼽힌거
ll plug_cnt; // 콘센트에 꼽힌 전기용품 개수

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	// 입력
	cin >> N >> K;
	for (ll i = 0; i < K; i++) cin >> arr[i];

	// plug에서 뺀 횟수
	ll cnt = 0;

	// 
	for (ll i = 0; i < K; i++) {
		// 이미 꼽혀 있다.
		if (plug[arr[i]] == 1) continue;
		// 빈 곳이 있다.
		else if (plug_cnt < N) {
			plug_cnt++;
			plug[arr[i]] = 1;
		}

		// 꽉 찼다.
		else {
			// 하나 뽑으니까 
			cnt++;

			// 만약에 플러그에서 빼야 한다면
			// 뭘 뺄지 우선순위를 매겨보자
			ll priority[MX] = { 0 }; // 1순위
			ll priority_tmp[MX] = { 0 }; // 2순위
			ll diff = 0;

			// 현재 콘센트에 꼽을려는 전기용품부터
			// 서로 다른 전기용품의 종류의 개수 = diff가 N보다 클 때까지
			// 등장하는 전기용품의 횟수
			// 2 8 			
			// 1 2 3 4 3 4 2 2
			for (ll j = i; j < K; j++) {
				if (priority[arr[j]] == 0) {
					if (diff == N) break;
					diff++;
				}
				priority[arr[j]]++;
			}

			// 현재 콘센트에 꼽을려는 전기용품부터
			// 끝날 때까지 등장하는 횟수
			// 3 11
			// 1 2 3 4 5 6 3 1 2 1 2
			for (j = i; j < K; j++) {
				priority_tmp[arr[j]]++;
			}

			// 꼽힌거 중에서 우선순위가 제일 낮은 하나를 뽑는다.
			ll mn = MX;
			ll idx = 0;
			for (ll j = 1; j <= K; j++) {
				if (plug[j] == 1) {
					// 1순위
					if (mn > priority[j]) {
						mn = priority[j];
						idx = j;
					}

					// 2순위
					else if (mn == priority[j]) {
						if (priority_tmp[idx] > priority_tmp[j]) {
							idx = j;
						}
					}
				}
			}
			plug[arr[i]] = 1;
			plug[idx] = 0;
		}
	}
	cout << cnt;
}
