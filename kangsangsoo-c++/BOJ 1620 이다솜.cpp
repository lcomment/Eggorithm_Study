#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef tuple<ll, ll, ll> tlll;

#include <unordered_map>

ll N, M;
unordered_map <string, int> mp1; 
unordered_map <int, string> mp2;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> N >> M;

	string str;
	for (int i = 1; i <= N; i++) {
		cin >> str;
		mp1[str] = i;
		mp2[i] = str;
	}

	for (int i = 1; i <= M; i++) {
		cin >> str;

		// 숫자면
		if ('0' <= str[0] && str[0] <= '9') {
			int num = stoi(str);
			cout << mp2[num] << '\n';
		}

		// 알파벳이면
		else {
			cout << mp1[str] << '\n';
		}
	}


}
