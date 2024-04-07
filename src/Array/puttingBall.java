package Array;

import java.util.Arrays;
import java.util.Scanner;

public class puttingBall {

  public static void main(String[] args) {
    putBall();
    putBall2();
  }

  public static void putBall() {
    Scanner scan = new Scanner(System.in);
    String[] NM = scan.nextLine().split(" ");
    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);

    int[] puttingArr = new int[N];

    for (int i = 0; i < M; i++) {
      String[] arr = scan.nextLine().split(" ");

      for(int j = Integer.parseInt(arr[0]) - 1; j < Integer.parseInt(arr[1]); j++)
      {
        puttingArr[j] = Integer.parseInt(arr[2]);
      }
    }
    System.out.println(Arrays.toString(puttingArr));
  }

  public static void putBall2() {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];

    int M = sc.nextInt();
    for(int i=0; i<M; i++) {
      int F = sc.nextInt(); // F번 바구니부터
      int E = sc.nextInt(); // E번 바구니까지
      int ball = sc.nextInt(); // ball번 공을 넣는다

      for(int j = F-1; j<E; j++)
      {
        arr[j] = ball;
      }
    }

    for (int baguni : arr)
      System.out.print(baguni + " ");
  }

}
