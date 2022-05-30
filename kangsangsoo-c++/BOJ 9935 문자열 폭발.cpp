#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef tuple<ll, ll, ll> tlll;

string s1, s2;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);


	cin >> s1 >> s2;
	
	stack <pair<char, int>> st;

	// ex
	// s1: zabcadf
	// s2: abc
	// stack: [ {z,-1} ]
	// stack: [ {z,-1}, {a, 0} ]
	// stack: [ {z,-1}, {a,0}, {b,1} ]
	// stack: [ {z,-1}, {a,0}, {b,1}, {c, 2} ]
	// stack: [ {z,-1} ]
	// stack: [ {z,-1}, {a,0} ]
	// stack: [ {z,-1}, {a,0}, {d,-1} ]
	// stack: [ {z,-1}, {a,0}, {d,-1}, {f,-1} ]

	for (auto ch : s1) {
		// 스택이 비었으면
		// 폭발문자열의 0번 인덱스 문자랑 비교
		if (st.empty()) {
			if (ch == s2[0]) st.push({ ch, 0 });
			else st.push({ ch, -1 });
		}

		// 스택이 비지 않으면
		else {
			// 스택 top에서 연속되었던 폭발문자열의 인덱스(y)를 가져옴
			int x, y; tie(x, y) = st.top();
			
			// 연속되면
			if (ch == s2[y + 1]) {
				st.push({ ch, y + 1 });
			}
		
			// 연속되지 않고 0번인덱스 문자와 같다면
			else if (ch == s2[0]) st.push({ ch, 0 });

			// 그 외
			else st.push({ ch, -1 });	
		}

		// 폭발문자열이 만족되면
		// 폭발문자열 길이만큼 스택에서 pop
		if (st.top().second == s2.size() - 1) {
			for (int i = 0; i < s2.size(); i++) st.pop();
		}
	}


	// 정답 출력
	stack <char> ans;
	while (!st.empty()) {
		ans.push(st.top().first); st.pop();
	}
	if (ans.empty()) cout << "FRULA";
	else {
		while (!ans.empty()) {
			cout << ans.top(); ans.pop();
		}
	}
	
}
