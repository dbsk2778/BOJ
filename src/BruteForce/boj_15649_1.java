package BruteForce;

import java.util.Scanner;

public class boj_15649_1 {

  /*
    BOJ 15649 : N과 M (1) == 순열 (Permutation) = 중복을 허용 없이  (11, 22, 33, 44, 112 , 221, 313 이런거 안됨)
    문제: 자연수 N과 M이 주어졌을 때, 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 모두 구하는 프로그램을 작성하시오.
    시간 복잡도 : O(N!) : 8! = 40,320, 10! = 3,628,800
   */

  /*
  중복 순열과 순열의 차이점
    1. 중복 순열은 순열과 다르게 같은 수를 여러 번 골라도 된다.
    2. 중복 순열의 경우, 방문 여부를 확인하는 배열을 사용하지 않는다.
   */

  /*
     완전 탐색 문제를 접근할 때는,
     1) 고를 수 있는 값의 종류 파악하기
     2) 중복을 허용하는지
     3) 순서가 중요한지 파악하기
   */

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] selected, used;

  public static void input() {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    M = scan.nextInt();
    selected = new int[M + 1];
    // 어떤 숫자가 쓰였는지 쓰이지 않았는지를 기록하는 배열
    used = new int[N + 1];
  }

  public static void main(String[] args) {
    input();
    rec_func(1);
    System.out.println(sb.toString());
    input();
    rec_func2(1);
  }

  // for문이 하나 더 추가되므로, 시간 복잡도는 높아진다.
  public static void rec_func(int k) {
    if (k == M + 1) {
      for (int i = 1; i <= M ; i++) {
        sb.append(selected[i]).append(' ');
      }
      sb.append('\n');
    } else {
      for (int cand = 1; cand <= N; cand++) {
        // 중복을 허용하지 않음 (selected 배열에 같은 수가 있는지 확인)
        boolean isUsed = false;
        for (int i = 1; i < k; i++) {
          // 만약 i번째 숫자가 이번에 넣을 cand와 같다면
          if (selected[i] == cand) {
            isUsed = true;
            break;
          }
        }
        // 한번도 사용된적이 없다면?
        if (!isUsed) {
          selected[k] = cand;
          rec_func( k + 1);
          selected[k] = 0;
        }
      }
    }
  }

  // used 배열 사용 (어떤 숫자가 쓰였는지 기록하는 배열) - 시간 복잡도 줄이기
  public static void rec_func2(int k) {
    if (k == M + 1) {
      for (int i = 1; i <= M; i++) {
        System.out.print(selected[i] + " ");
      }
      System.out.println();
    } else {
      for (int cand = 1; cand <= N; cand++) {
        // 중복을 허용하지 않음 (selected 배열에 같은 수가 있는지 확인)
        if (used[cand] == 1) {  // 배열만 확인하면 됨
          continue;
        }
        // k번째에 cand가 올 수 있으면
        selected[k] = cand;
        used[cand] = 1;
        rec_func2(k + 1);
        selected[k] = 0;
        // 다 쓴 다음에 다시 0으로 초기화, 재귀호출을 할때는 초기화를 잘 해줘야 함
        used[cand] = 0;
      }
    }
  }
}
