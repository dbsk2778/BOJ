package BruteForce.bf_1;

import java.util.Scanner;

public class boj_15652 {

  // 고른 수열이 비내림차순인지 확인하는 함수 - 즉, 오름차순이거나 같은 수가 나오는 경우
  // 시간 복잡도는 4*4*4*4 = 256번 연산 보단 작다.
  // 시간 복잡도는 O(N^M) : 최악의 경우 82만번 연산 (1억 미만이면 대략 1초)
  static StringBuilder sb = new StringBuilder();
  static int n, m; // 사용해야 할 변구
  static int[] selected; // 선택된 수열을 저장하는 배열

  static void input() {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    selected = new int[m + 1];
  }

  // Recurrence Function (재귀 함수)
  // 1. 만약 M개를 전부 고름 --> 조건에 맞는 탐색을 한 가지 성공한 것.
  // 2. 아직 M개를 고르지 않음 --> k번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도.
  static void rec_func(int k) {
    if (k == m + 1) { // 다 골랐을 경우
      // selected[1...M] 배열이 새롭게 탐색된 결과
      // selected 배열 출력 (하나의 결과값 만들어낸 것)
      for (int i = 1; i <= m; i++) {
        sb.append(selected[i]).append(' ');
        sb.append('\n');
      }
    } else {
      int start = selected[k - 1]; // 오름차순을 위해 선택된 수열의 마지막 원소를 저장
      if (start == 0) start = 1; // 0이면 1부터 시작
      // 가능한 숫자의 시작인 start보다 큰 값들만 가능
      for (int cand = start; cand <= n; cand++) {
        selected[k] = cand;
        // k+1 번지부터 M 번지까지 수를 고르는 모든 방법을 탐색
        rec_func(k + 1);
        selected[k] = 0;
      }
    }
  }

  public static void main(String[] args) {
    input();
    // 1번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색
    rec_func(1);
    System.out.println(sb.toString());
  }
}
