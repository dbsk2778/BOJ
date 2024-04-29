package BruteForce;

import java.util.Scanner;

public class boj_15651_2 {

  static StringBuilder sb = new StringBuilder();
  static int n, m; // 사용해야 할 변수
  static int[] selected2; // 선택된 수열을 저장하는 배열

  public static void main(String[] args) {
    input();
    rec_func(1);
    System.out.println(sb.toString());
  }

  static void input() {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    selected2 = new int[m + 1];  // m 까지의 수열을 저장하는 배열
  }

  // 중복 순열을 구하는 방법 (중복 허용) = 중복 순열은 순열과 다르게 같은 수를 여러 번 골라도 된다.
  // 시간 복잡도는 O(N^M) : 최악의 경우 82만번 연산 (1억 미만이면 대략 1초)
  static void rec_func(int k) {
    if (k == m + 1) { // 다 골랐을 경우
      // selected[1...M] 배열이 새롭게 탐색된 결과
      // selected 배열 출력 (하나의 결과값 만들어낸 것)
      for (int i = 1; i <= m; i++) {
        sb.append(selected2[i]).append(' ');
        sb.append('\n');
      }
    } else {
      // k 번째 원소에 1부터 N까지 차례대로 들어올 수 있다는 것을 의미 (candidate)
      for (int cand = 1; cand <= n; cand++) {
        selected2[k] = cand;
        // k+1 번지부터 M 번지까지 수를 고르는 모든 방법을 탐색
        rec_func(k + 1);
        selected2[k] = 0;
      }
    }
  }
}
