package ForStatements;

import java.util.Scanner;

public class forStatements {

  public static void main(String[] args) {
    printGugudan();  // 백준 2739
    printAplusB();   // 뱍쥰 10950
    sum();
  }

  public static void printGugudan() {
    Scanner scan = new Scanner(System.in);

    int dan = scan.nextInt();

    for (int i = 1; i <= 9; i++) {
      System.out.println(dan + " * " + i + " = " + dan * i);
    }
  }

  public static void printAplusB() {
    Scanner scan = new Scanner(System.in);

    int num = scan.nextInt();

    int[] A = new int[num];
    int[] B = new int[num];

    for ( int i = 0; i < num; i++ ) {
      A[i] = scan.nextInt();
      B[i] = scan.nextInt();
    }

    for (int i = 0; i < num; i++ ) {
      int sum = A[i] + B[i];
      System.out.printf("%d\n", sum);
    }
  }

  public static void sum() {
    Scanner scan = new Scanner(System.in);

    int num = scan.nextInt();
    int sum = 0;

    for (int i = 0; i <= num; i++) {
      sum += i;
    }

    System.out.println(sum);
  }
}
