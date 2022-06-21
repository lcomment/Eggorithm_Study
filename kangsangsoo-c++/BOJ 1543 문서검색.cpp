#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<ll, ll> pll;
typedef tuple<ll, ll, ll> tlll;

#define MX 2505

char a[MX], b[MX];

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	// 입력
	cin.getline(a, MX);
	cin.getline(b, MX);


	int cnt = 0;
	for (int i = 0; i < strlen(a);) {

		// 문자열이 일치하는지 확인
		int flag = 1;
		for (int j = 0; j < strlen(b); j++) {
			if (a[i + j] != b[j]) {
				flag = 0;
				break;
			}
		}

		// 매칭되면 문자열 길이만큼 +
		if (flag == 1) {
			i += strlen(b);
			cnt++;
		}

		// 매칭되지 않으면 1+
		else i++;
	}
	cout << cnt;
}
