#include <bits/stdc++.h>

using namespace std;

vector <ll> v;
vector <ll> ans(6);
ll k;

// ans[0], ans[1], ..., ans[5] 순으로 출력
// ans[num] = v[i]에서
// num은 ans 배열의 인덱스를 의미 
// nxt는 i ∈ [nxt, k - (6-num)]로 제한
void func(int num, int nxt) {
	if (num == 6) {
		for (auto i : ans) {
			cout << i << ' ';
		}
		cout << '\n';
		return;
	}
	for (int i = nxt; i < k - (5 - num); i++) {
		ans[num] = v[i];
		func(num + 1, i + 1);
	}
}


int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	while (1) {
		cin >> k;
		if (k == 0) break;
		v.clear();

		ll num;
		
		// 배열 v에 숫자 삽입
		for (int i = 0; i < k; i++) {
			cin >> num;
			v.push_back(num);
		}

		// 백트래킹
		func(0, 0);
		cout << '\n';
	}
}
