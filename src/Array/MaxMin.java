package Array;

import java.util.Scanner;

public class MaxMin {

  public static void main(String[] args) {
    minMax();
  }

  public static void minMax() {
    Scanner scan = new Scanner(System.in);

    String N = scan.nextLine();  // 정수의 개수
    String M = scan.nextLine();  // N개의 정수

    String[] arr = M.split(" ");

    int x = Integer.parseInt(arr[0]);
    int max = x;
    int min = x;

    for (int i = 0; i < Integer.parseInt(N); i++) {
      if (Integer.parseInt(arr[i]) > max) {
        max = Integer.parseInt(arr[i]);
      }
      if (Integer.parseInt(arr[i]) < min) {
        min = Integer.parseInt(arr[i]);
      }
    }
    System.out.println(min + " " + max);
  }
}
