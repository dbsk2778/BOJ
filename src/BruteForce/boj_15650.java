package BruteForce;

import java.util.Scanner;

public class boj_15650 {

  // 오름차순으로 출력 <_> 15652와 다른 점 (비내림차순)
  // 조합 (Combination) : 서로 다른 n개에서 순서에 상관없이 서로 다른 r개를 선택하는 것
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
      //
      for (int cand = selected[k-1]; cand <= n; cand++) {
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
