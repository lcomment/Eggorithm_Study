#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
#define MX 20005

ll T, A, B;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	cin >> T;
	for (ll i = 0; i < T; i++) {
		// 입력
		cin >> A >> B;
		vector <int> a(A), b(B);
		for (ll j = 0; j < A; j++) {
			cin >> a[j];
		}
		for (ll j = 0; j < B; j++) {
			cin >> b[j];
		}

    // 오름차순 정렬
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());

		ll a_ptr = a.size() - 1;
		ll b_ptr = b.size() - 1;

		ll cnt = 0;
		/*
		A: [1, 3, 5, 7] 
		B: [2, 4, 6,  ]
		A[3] > B[2]  
    A[2] > B[1]
    A[1] > B[0]
    output: (2+1) + (1+1) + (0+1)
		*/
		while (a_ptr >= 0 && b_ptr >= 0) {
			if (a[a_ptr] > b[b_ptr]) {
				cnt += b_ptr + 1;
				a_ptr--;
			}
			else {
				b_ptr--;
			}
		}
		cout << cnt << '\n';
	}

}
