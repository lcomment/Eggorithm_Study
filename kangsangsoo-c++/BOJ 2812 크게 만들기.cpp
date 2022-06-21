#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

ll N, K;
string str;
queue <ll> q[10];

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	// 입력	
	cin >> N >> K >> str;

	// 0~9까지 각 숫자의 위치를 큐에 저장
	for (ll i = 0; i < str.size(); i++) {
		q[str[i] - '0'].push(i);
	}

	// 아이디어
	// 길이가 같은 수끼리 비교할 때 높은 자리가 크면 된다.

	string ans; // 출력할 정답 문자열
	ll current_idx = 0; // 현재 조사하고 있는 인덱스
	ll remainer = K; // 제거할 수 있는 횟수


  // N-K는 우리가 출력한 문자열 길이
	// 정답 문자열의 0번째 인덱스부터 N-K-1번째 인덱스까지 찾아보겠다.
	for (ll i = 0; i < N - K; i++) {

		// 우리가 제거할 수 있는 횟수가 없으므로 그대로 복붙
		if (remainer == 0) {
			ans += str.substr(current_idx);
			break;
		}


		// 현재 remainer 범위에서 제일 큰 수 찾기
		// 9부터 0까지 찾아봄
		ll find_flag = 0;
		for (ll j = 9; j >= 0; j--) {
			// 아직 못 찾은 경우
			if (find_flag == 0) {
				while (1) {
					// 큐가 빈 경우
					if (q[j].empty()) break; 

					// 현재 remainer 범위인 경우
					if (q[j].front() <= current_idx + remainer) {
						find_flag = 1;
						ans.push_back('0' + j);
						
						// 제거한 만큼 remainer 갱신
						remainer -= q[j].front() - current_idx;

						// 현재 인덱스 갱신
						current_idx = q[j].front() + 1;
						q[j].pop();
						break;
					}

					// 범위밖인 경우
					else {
						break;
					}
				}
			}

			// 이미 찾은 경우
			else {
				while (1) {
					if (q[j].empty()) break;
					if (q[j].front() >= current_idx) break;

					// 현재 인덱스보다 작은 위치에 있는 애들은 큐에서 pop
					else q[j].pop();
				}
			}
		}	
	}

	cout << ans;
}
