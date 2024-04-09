package Bfs;

import java.util.Scanner;

public class theory {

  // 완전 탐색 : 모든 경우의 수 다 해보기 = Brute Force (별도의 최적화 없이, 효율성을 고려하지 않는 풀이 방법)
  // 문제 해결의 가장 기본적인 방법, 정답률 100% 보장 (시간복잡도의 효율은 낮다.)

  // ex. 4자리 숫자 암호 찾기: 0000 ~ 9999까지 모두 시도해보기

  // 완전 탐색
  // 모든 경우의 수를 체계적으로 검사할 수 있도록 설계해야 한다. 문제가 요구하는 바를 이해하고, 정확히 구현할 수 있어야 한다.
  // 가장 쉽고 간단한 접근
    // - 효율을 생각하지 않기 때문에 문제의 크기가 작으면 유용하다.
    // - 문제의 크기가 클수록 시간/공간 복잡도가 늘어가 적용이 어려울 수 있다.
    // - 완전한 정답이 되지 못하더라도 문제를 이해하거나 테스트케이스를 확인하기 위한 용도로 적용해볼 수 있다.
    // - 부분 점수 문제라면 전체를 풀지 못해도 작은 데이터에 대한 점수를 얻을 수 있다.
    // - 선형 완전 탐색, 비선형 완전 탐색이 있다.

  // 시뮬레이션
  // 문제에서 주어진 상황을 그대로 진행하며 해결해보는 기법
    // - 문제의 요구사항에 알맞은 코드 모델링
    // - 문제의 조건을 체계적으로 수행하기 위한 구현력이 필요
    // 백준 10158 개미: 1시간마다 움직이는 개미의 T시간 뒤 위치 구하기
    // 백준 10431 줄세우기: 문제가 요구하는 규칙에 맞춰 줄세우기


  public static void main(String[] args) {
    bfs();
  }

  // 2309 일곱 난쟁이
  // 9명의 난쟁이의 키가 주어질 때, 키의 합이 100이 되는 일곱 난쟁이를 찾아라. 일곱 난쟁이의 키를 오름차순으로 출력해라.
  // 7중 반복문을 사용하면 모든 경우를 다 보게 된다. 근데 이게 완전탐색이라고 할 수 있을까? 시간 복잡도는 O(n^7)이다.

  // 9명 중 일곱 난쟁이가 아닌 둘을 찾는 문제 풀이 = 시간 복잡도 O(n^2)
  public static void bfs() {
    Scanner scan = new Scanner(System.in);
    int[] height = new int[9]; // 난쟁이 키
    for (int i = 0; i < 9; i++) {
      height[i] = scan.nextInt();
    }

    int sum = 0; // 모든 난쟁이들의 합
    for (int i = 0; i < 9; i++) {
      sum += height[i];
    }

    boolean found = false;
    int[] ans = new int[7];

    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (sum - height[i] - height[j] == 100) {
          int ansIndex = 0;

          for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
              ans[ansIndex++] = height[k];
            }
          }
          found = true;
          break;
        }
        if (found) break;
      }
    }
    insertSort(ans);

    for (int i = 0; i < 7; i++) {
      System.out.println(ans[i]);
    }
  }

  // 삽입 정렬 알고리즘
  // 시간 복잡도 O(n^2)
  public static void insertSort(int[] ans) {
    for (int i = 1; i < ans.length; i++) {
      for (int j = 0; j < i; j++) {
        if (ans[i] < ans[j]) {
          int cur = ans[i];
          for (int k = i; k > j; k--) {
            ans[k] = ans[k - 1];
          }
          ans[j] = cur;
          break;
        }
      }
    }
  }
}
