package Array;

import java.util.Scanner;

public class theory {

  /*
   1. 자료구조 - 배열
   - 순서(index)를 가진 데이터의 집합으로 가장 기본적인 자료구조임.
   - 생성과 동시에 크기가 고정됨
   - 전체 원소가 메모리상에 일렬로 저장됨
   */

    public static void main(String[] args) {
        defaultArray();
        defaultArray2();
    }

    public static void defaultArray() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] arr = new int[N];   // 배열의 생성

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();   // 배열의 저장
        }

        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];  // 배열의 탐색, 원소의 접근
        }
        System.out.println(sum);
    }

    public static void defaultArray2() {
        int[] arr = {7, 9, 11, -11, 3, 66, 39};

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        long sum2 = 0;

        for (int j : arr) {  // 향상된 for문
            sum2 += j;
        }
        System.out.println(sum);
        System.out.println(sum2);
    }
}
