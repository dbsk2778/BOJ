package Array;

import java.util.Scanner;

public class theory {

  /*
   1. 자료구조 - 배열
   - 순서(index)를 가진 데이터의 집합으로 가장 기본적인 자료구조임.
   - 생성과 동시에 크기가 고정됨
   - 전체 원소가 메모리상에 일렬로 저장됨

   2. 배열에 대한 시간 복잡도
   - get(int idx) : idx 번째 원소 반환
     arr[i]가 가능한 이유? 메모리가 연속적이기 때문에 arr의 시작 주소로부터 idx만큼 떨어진 원소의 주소를 바로 계산하고, 접근할 수 있다.
     arr[i]는 한 번에 찾을 수 있기 때문에 시간 복잡도는 0(1)  == 상수 시간 복잡도
   - change(int idx, int val) : idx번째 원소를 val로 변경
   - append(int val) : 가장 뒤에 원소 삽입
   - insert(int idx, int val) : 현재 idx 번째 원소의 앞에 원소 삽입
   - erase(int idx) : idx 번째 원소 삭제


   */

  public static void main(String[] args) {
//    defaultArray();
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

    for (int i = 0; i < arr.length; i++){
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
