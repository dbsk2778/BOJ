package BruteForce.bf_2;

import java.util.Scanner;

public class boj_14888_1 {

  static int N, max, min;
  static int[] nums, operators, order;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    input();
    rec_func(1);
    sb.append(max).append('\n').append(min);
    System.out.println(sb.toString());
  }

  /*
    * N-1개의 카드 중에서 중복 없이 (같은 카드는 한 번 사용해서) N-1개의 카드를 사용하여 만들 수 있는 최대값과 최소값을 구하는 문제
    int 형의 범위 : -21억 ~ 21억
    1. N개의 수열이 주어질 때, N-1개의 연산자를 사용하여 만들 수 있는 최대값과 최소값을 구하는 문제
    2. N의 크기가 최대 11이므로, N-1개의 연산자를 사용하여 만들 수 있는 모든 경우의 수는 10! = 3,628,800가지이다.
   */

  static void input() {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    nums = new int[N + 1];
    operators = new int[5]; // +, -, *, /
    order = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      nums[i] = scanner.nextInt();
    }
    for (int i = 1; i <= 4; i++) {
      operators[i] = scanner.nextInt();
    }

    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;
  }

  // order[1...N-1] 배열에 연산자들을 순서대로 저장
  static void rec_func(int k) {
    // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
    if (k == N) {
      // 정한 연산자 순서대로 계산해서 정답 갱신
      int value = calculate();
      max = Math.max(max, value);
      min = Math.min(min, value);
    } else { // k벉째 연산자는 무엇을 선택할것인가?
      // 4가지의 연산자들 중에 뭘 쓸것인지를 선택하고 재귀호출
      for (int cand = 1; cand <= 4; cand++) {
        if (operators[cand] >= 1) {
          operators[cand]--;
          order[k] = cand;
          rec_func(k + 1);
          operators[cand]++;
          order[k] = 0;
        }
      }
    }
  }

  // 완성된 식에 맞게 계산을 해서 정답을 갱신하는 작업
  static int calculate() {
    // Nums, Order를 이용해서 계산을 해야함
    int value = nums[1];
    for (int i = 1; i < N; i++) {
      switch (order[i]) {
        case 1 -> value += nums[i + 1];
        case 2 -> value -= nums[i + 1];
        case 3 -> value *= nums[i + 1];
        case 4 -> value /= nums[i + 1];
      }
    }
    return value;
  }
}
