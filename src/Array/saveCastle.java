package Array;

import java.util.Scanner;

public class saveCastle {

  // 백준 1236 성 지키기
  public static void main(String[] args) {
    findSaveCasleCount2();
    findSaveCasleCount2();
  }

  public static void findSaveCasleCount1() {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int M = scan.nextInt();

    char[][] map = new char[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = scan.next().toCharArray();
    }

    // 1. 각 행/열에 대해 경비원이 있는지 확인한다.
    int existRowCount = 0;  // 각각의 열에 대해 경비원이 지키고 있는 Row는?

    for (int i = 0; i < N; i++) {  // 확인하고 싶은 row
      boolean exist = false;
      for (int j = 0; j < M; j++) {  // row의 각 칸을 보면서 경비원이 있는지 확인
        if (map[i][j] == 'X') {
          exist = true;
          break;
        }
        if (exist) {
          existRowCount++;
        }
      }
    }

    int existColCount = 0;  // 각각의 열에 대해 경비원이 지키고 있는 Column는?

    for (int k = 0; k < M; k++) {  // 확인하고 싶은 col
      boolean exist = false;
      for (int x = 0; x < N; x++) {  // col의 각 칸을 보면서 경비원이 있는지 확인
        if (map[k][x] == 'X') {
          exist = true;
          break;
        }
        if (exist) {
          existColCount++;
        }
      }
    }

    // 2. 보호받지 못하는 행 / 열의 개수를 구한다.
    int needRowCount = N - existRowCount;
    int needColumnCount = N - existColCount;

    // 3. 둘 중 큰 값을 출력한다.
    System.out.println(Math.max(needRowCount, needColumnCount));
  }

  public static void findSaveCasleCount2() {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int M = scan.nextInt();

    char[][] map = new char[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = scan.next().toCharArray();
    }

    boolean[] existRow = new boolean[N];
    boolean[] existCol = new boolean[M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'X') {
          existRow[i] = true;
          existCol[j] = true;
        }
      }
    }

    int needRowCount = N;
    int needColumnCount = M;

    for (int i = 0; i < N; i++) {
      if (existRow[i]) {
        needRowCount--;
      }
    }
    for (int i = 0; i < M; i++) {
      if (existCol[i]) {
        needColumnCount--;
      }
    }

    // 3. 둘 중 큰 값을 출력한다.
    System.out.println(Math.max(needRowCount, needColumnCount));
  }
}
