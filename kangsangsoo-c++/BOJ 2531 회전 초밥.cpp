#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
#define MX 60005
ll N, d, k, c;

ll arr[MX];
ll check[MX];

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	// 입력
	// 회전 초밥이기 때문에 
  // 배열 2개를 이어 붙여서 원형 큐와 같이 동작하도록 함.
  // arr + arr
	cin >> N >> d >> k >> c;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		arr[i + N] = arr[i];
	}

  // 현재 범위 안에 있는 초밥의 개수를 센다.
	ll cnt = 0;
	for (int i = 0; i < k; i++) {
		check[arr[i]]++;
		if (check[arr[i]] == 1) cnt++;
	}

  // 쿠폰으로 준 초밥도 센다
	check[c]++;
	if (check[c] == 1) cnt++;
   
  // [l, r]을 오른쪽으로 1칸씩 움직일 때마다 바뀌는 값을 체크
	ll l = 0, r = k - 1;
	ll mx = 0;
	mx = max(mx, cnt);
	for (int i = 1; i <= N+1; i++) {
    // 제일 좌측은 빠지고
		check[arr[l]]--; 
		if (check[arr[l]] == 0) cnt--;
		l++;

    // 제일 우측은 추가
		r++;
		check[arr[r]]++;
		if (check[arr[r]] == 1) cnt++;
		mx = max(mx, cnt);
	}

	cout << mx;
}
