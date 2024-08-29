package Sort.sort.sort_2;

import java.util.Arrays;
import java.util.Scanner;

public class _1181 {


  public static void main(String[] args) {
    sortWords();
  }

  // N개의 단어에 대해 중복을 제거하고 아래 조건에 맞게 정렬 - 중복 제거 후 정렬하는 것보다 정렬 후 중복을 건너뛰는 게 훨씬 쉽다 (정렬 후, 같은 값은 연속해서 모여있기 때문에)
  // 1. 길이가 짧은 것부터
  // 2. 길이가 같으면 사전 순으로
  // 조건에 맞게 정렬 : 시간복잡도 (0L * NlogN)
  public static void sortWords() {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    String[] words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = scan.next();
    }

    // NlogN * L(들어올 수 있는 문자의 길이)
    // 그냥 words를 정렬하면 사전순으로 정렬됨
    Arrays.sort(words, (o1, o2) -> {
      // 길이가 같으면 사전순으로 정렬
      if (o1.length() == o2.length()) {
        return o1.compareTo(o2);
      }
      // 길이가 짧은 것부터 정렬 - 오름차순
      return o1.length() - o2.length();
    });

    // 중복 제거
    // 이전 값과 다를 때에만 출력 (시간복잡도 O(L * N)
    System.out.println(words[0]);  // 첫번째 값 무조건 출력
    for (int i = 1; i < n; i++) {
      if (!words[i].equals(words[i - 1])) {
        System.out.println(words[i]);
      }
    }
  }
}
