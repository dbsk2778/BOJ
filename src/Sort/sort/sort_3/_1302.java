package Sort.sort.sort_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1302 {

  public static void main(String[] args) {
    findBestSeller();
    findBestSellerBySort();
    findBestSellerByMap();
  }

  public static void findBestSeller() {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();

    String[] titles = new String[N];
    int[] titleCount = new int[N];

    for (int i = 0; i < N; i++) {
      titles[i] = scan.next();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (titles[j].equals(titles[i])) {
          titleCount[i]++;
        }
      }
    }

    String maxTitle = "";
    int maxCount = 0;
    for (int i = 0; i < N; i++) {
      if (titleCount[i] > maxCount
          || titleCount[i] == maxCount && titles[i].compareTo(maxTitle) < 0) {
        maxCount = titleCount[i];
        maxTitle = titles[i];
      }
    }

    System.out.println(maxTitle);
  }

  // 정렬하면 같은 책들이 연속해서 모일테니, 한번에 구할 수 있다.
  public static void findBestSellerBySort() {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();

    String[] titles = new String[N];

    for (int i = 0; i < N; i++) {
      titles[i] = scan.next();
    }

    // 사전순 정렬
    Arrays.sort(titles);

    String maxTitle = titles[0];
    int maxCount = 1;
    int currentCount = 1;
    for (int i = 1; i < N; i++) {
      // 지금 보고 있는 타이틀이 이전 타이틀과 동일하지 않다면, 현재 카운트를 0으로 초기화
      if (!titles[i].equals(titles[i - 1])) {
        currentCount = 0;
      }
      currentCount++; // 동일한 카운트면 그냥 증가시켜주면됨 !!

      if (currentCount > maxCount
          // 사전순으로 앞설 경우 : 내가 사전순으로 앞설려면 compareTo가 0보다 작아야함
          || currentCount == maxCount && titles[i].compareTo(maxTitle) < 0) {
        maxCount = currentCount;
        maxTitle = titles[i];
      }
    }
    System.out.println(maxTitle);
  }

  // Map을 이용한 풀이
  // 중복된 키를 가지지 않고, key: value의 쌍을 담는 컬렉션
  // put, remove, containsKey: o(1) ~ o(log(size))의 시간복잡도를 가진다.
  // 시간 복잡도 (O(N * LlogN))
  public static void findBestSellerByMap() {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();

    Map<String, Integer> titles = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String title = scan.next();
      // 값이 있으면 get, 없으면 0을 반환하고 +1을 해준다.
      // 없는 값에 get을 하면 NullPointException이 발생하므로 getOrDefault를 사용한다.
      titles.put(title, titles.getOrDefault(title, 0) + 1);
      // 위 한줄이 아래 역할을 함
//      if (titles.containsKey(title)) {
//        titles.put(title, titles.get(title) + 1);
//      } else {
//        titles.put(title, 1);
//      }
    }

    String maxTitle = "";
    int maxCount = 0;

    // Map의 원소쌍 탐색 방법 entrySet
    for (Map.Entry<String, Integer> title : titles.entrySet()) {
      String titleName = title.getKey();
      int count = title.getValue(); // titles.get(titleName)로도 가능

      if (count > maxCount || count == maxCount && titleName.compareTo(maxTitle) < 0) {
        maxCount = count;
        maxTitle = titleName;
      }
    }
    System.out.println(maxTitle);
  }
}
