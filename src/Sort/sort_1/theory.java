package Sort.sort_1;

import java.util.Arrays;

public class theory {

  // 정렬: 데이터 집합을 적합한 순서로 배치하는 것
  // 유명한 N^2 알고리즘: 버블 정렬, 삽입 정렬, 선택 정렬
  // 유명한 NlogN 알고리즘: 퀵 정렬, 병합 정렬, 힙 정렬
  // 그 외: 기수 정렬, 계수 정렬, 쉘 정렬, 팀 정렬, 트리 정렬, 블록 정렬, 외부 정렬

  // 최대 1,000,000개의 정수를 오름차순 정렬하는 문제: N^2 알고리즘은 시간초과가 발생
  public static void main(String[] args) {
    sortScoresDescendingOrder(new Score[] {new Score(1), new Score(3), new Score(2), new Score(4), new Score(5)});
    sortNumbers();
    sortString();
  }

  // 내림차순 정렬
  public static void sortScoresDescendingOrder(Score[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        // 앞에있는 데이터가 뒤에있는 데이터보다 커야한다는 기준으로 정렬
        if (arr[i].getScore() > arr[j].getScore()) {
          Score temp = arr[i];
          for (int k = i; k > j; k--) {
            arr[k] = temp;
          }
        }
      }
    }
  }


  // 배열을 정리하는 sort 함수가 존재한다. = Arrays.sort() = 오름차순 정렬
  // Primitive[] sort
  // Dual-Pivot Quicksort - 평균 시간복잡도 : NlogN, 최악 시간복잡도 : N^2 : stable하지 않음 (Unstable sort: 같은 값의 순서가 바뀔 수 있음, 어떤 순서도 가능)
  public static void sortNumbers() {
    int[] arr = {2, 3, 1, 4, 5};
    Arrays.sort(arr);
    for (int num : arr) {
      System.out.println(num);
    }
  }

  // String은 사전순 정렬임 = 오름차순 정렬이 아님.
  // Object[] sort
  // Tim sort (merge sort 기반) - 평균 시간복잡도 - NlogN, 최악 시간복잡도 - NlogN : stable함 (같은 위상을 가진 값이라면 입력순서가 먼저인 것이 먼저 나옴)
  public static void sortString() {
    String[] arr = {"k8s", "cake", "banana", "cherry", "ramen", "date", "ajax", "elderberry"};
    Arrays.sort(arr);
    for (String str : arr) {
      System.out.println(str);
    }
  }

}
