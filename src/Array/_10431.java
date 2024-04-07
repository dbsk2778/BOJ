package Array;

import java.util.Scanner;

public class _10431 {

  // 문제: 입력으로 주어진 순서대로 규칙에 따라 줄을 설 때, 각 학생들이 뒤로 물러난 걸음 수의 총합
  // int가 아니라 long을 사용해야할수도 있다. (int의 범위를 넘어설 수 있음)


  // 내 시간 복잡도에는 문제가 없는데 시간 초과가 난다면?
  // 1. 입력을 받는 부분을 수정해본다. (Scanner -> BufferedReader)
  // 2. 출력을 하는 부분을 수정해본다. (System.out.println -> StringBuilder)
  // 3. 시간 복잡도를 줄일 수 있는 방법을 찾아본다. (예: 정렬을 사용하면 시간 복잡도를 줄일 수 있다.)

  /**
   * 1. 학생들은 줄을 설 때, 앞에 있는 학생들보다 키가 크면 뒤로 물러난다. 2. 뒤로 물러난 걸음 수는 앞에 있는 학생들 중 자신보다 키가 큰 학생들의 수이다. 3. 각
   * 학생들이 뒤로 물러난 걸음 수의 총합을 구하는 프로그램을 작성 = 모든 학생이 오름차순으로 줄서기
   */
  public static void main(String[] args) {
    _10431_1();
    _10431_2();
  }

  // 시간 복잡도 O(n^3)
  public static void _10431_1() {
    Scanner scan = new Scanner(System.in);
    int count = Integer.parseInt(scan.nextLine());

    int num = 0;

    for (int i = 0; i < count; i++) {
      String[] arr = scan.nextLine().split(" ");

      for (int j = 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (Integer.parseInt(arr[j]) > Integer.parseInt(arr[k])) {
            num += 1;
          }
        }
      }
      System.out.println(arr[0] + " " + num);
      num = 0; // 초기화
    }
  }

  // 시간 복잡도 O(P * n^2) = O(n^2)
  public static void _10431_2() {
    Scanner scan = new Scanner(System.in);
    int P = scan.nextInt();  // 테스트케이스 개수

    // 아래와 동일한 for문: for (int p = 0; p < P; p++) { // 테스트케이스 개수만큼 반복 (P는 테스트케이스 개수)
    while (P-- > 0) {  // P는 테스트케이스 이외로는 사용하지 않는 변수이기 때무에 --를 사용하여 0이 될 때까지 반복
      int T = scan.nextInt();
      int[] arr = new int[20]; // 이미 문제에서 주어져 있음 (학생 수는 20명)

      for (int i = 0; i < 20; i++) {
        arr[i] = scan.nextInt();
      }

      int count = 0;
      int[] sortedArr = new int[20]; // 정렬된 배열

      for (int i = 0; i < 20; i++) {
        // 1. 줄 서있는 학생 중에 자신보다 큰 학생을 찾는다.
        // 1.1 찾지 못햇다면, 줄의 가장 뒤에 선다.
        boolean find = false;
        for (int j = 0; j < i; j++) {
          if (sortedArr[j] > arr[i]) {
            // 2. 찾았다면, 그 학생의 앞에 선다.
            // 3. 그 학생과 그 뒤의 학생이 모두 한칸씩 물러난다. (뒤로 한칸씩 이동)
            find = true;
            // 배열의 이동 = --로 해줘야 함
            // 애는 find가 true일 때만 실행되므로, 한번만 실행됨 (시간복잡도에 영향이 없음)
            for (int k = i - 1; k > j - 1; k--) {
              sortedArr[k + 1] = sortedArr[k];
              count++;
            }
            sortedArr[j] = arr[i];
            break;
          }
        }
        if (!find) {
          sortedArr[i] = arr[i];
        }
      }
      System.out.println(T + " " + count);
    }
  }
}