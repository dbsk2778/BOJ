package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class numberCount {

  // 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
  public static void main(String[] args) throws Exception {
    numberCount1();
    numberCount2();
  }

  public static void numberCount1() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      a[i] = num;
    }
    int f = sc.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == f) {
        sum++;
      }
    }
    System.out.println(sum);
  }

  public static void numberCount2() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int f = Integer.parseInt(br.readLine());

    int sum = 0;

    while(st.hasMoreTokens()) {
      if(Integer.parseInt(st.nextToken())==f) sum++;
    }
    System.out.println(sum);
  }
}
