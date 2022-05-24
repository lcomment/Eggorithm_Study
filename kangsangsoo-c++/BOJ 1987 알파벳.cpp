#include <bits/stdc++.h>

using namespace std;


vector <string> v;

ll R, C;

ll dx[4] = { 0, 0, 1, -1 };
ll dy[4] = { 1, -1, 0, 0};

ll mx;
ll visited[26];

// (x, y)에 방문하는데 길이는 num
void func(ll x, ll y, ll num) {
	// 최대값 갱신
	mx = max(mx, num);

	// 4방향 모두 체크
	for (int i = 0; i < 4; i++) {
		ll nx = x + dx[i];
		ll ny = y + dy[i];

		// 2차원 범위를 벗어나는지 확인
		if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
		// 이미 방문했는지 확인
		if (visited[v[nx][ny]-'A'] == 1) continue;

		// 방문 표시하고 다음 위치로
		visited[v[nx][ny] - 'A'] = 1;
		func(nx, ny, num + 1);

		// 원상복구 시킴
		visited[v[nx][ny] - 'A'] = 0;
	}
}

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> R >> C;
	string s;

	// 2차원으로 입력을 받는다.
	for (int i = 0; i < R; i++) {
		cin >> s;
		v.push_back(s);
	}

  // 시작 지점을 표시한다.
	visited[v[0][0] - 'A'] = 1;
  // 시작 위치에서 백트래킹 시작
	func(0, 0, 1);

	cout << mx;
}
