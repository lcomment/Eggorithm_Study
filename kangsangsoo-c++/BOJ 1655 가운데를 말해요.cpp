#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef tuple<ll, ll, ll> tlll;

ll N;

int main(void) {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> N;

	// 내림차순
	priority_queue <int, vector<int>, less<int>> pq1;

	// 오름차순
	priority_queue <int, vector<int>, greater<int>> pq2;


	// [pq1] < 중간(mid) <= [pq2]
  // 

	// 입력받은 개수가
	// 홀수일 때는 pq1.size() = pq2.size()
	// 짝수일 때는 pq1.size() = pq2.size() - 1

	// 삽입에 O(logn)
	// n번하므로 O(nlogn)

	int num;
	int mid;
	cin >> mid;
	cout << mid << '\n';

	for (int i = 2; i <= N; i++) {
		cin >> num;

		// 홀수일 때는 pq1.size() = pq2.size()이어야 해서
		// pq1에 넣는다.
		if (i % 2 == 1) {

			if (mid > num) {
				pq1.push(num);
			}
			else {
				pq1.push(mid);

				// pq2.top()하고 num의 크기를 비교해서 작은 것을 선택
				pq2.push(num);
				mid = pq2.top(); pq2.pop();
			}
		}

		// 짝수일 때는 pq1.size() = pq2.size() - 1이어야 해서
		// pq2에 넣는다.
		else {
			if (mid > num) {
				pq2.push(mid);

				// pq1.top()하고 num의 크기를 비교해서 큰 것을 선택
				pq1.push(num);
				mid = pq1.top(); pq1.pop();
			}
			else {
				pq2.push(num);
			}
		}

		// 중간값 출력
		cout << mid << '\n';
	}

	
}
