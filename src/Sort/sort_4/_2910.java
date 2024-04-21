package Sort.sort_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _2910 {

  public static void main(String[] args) throws IOException {
    solution();
  }

  // N개의 수가 주어질 때 아래 조건에 맞게 정렬
  /*
    2. 등장한 횟수가 많은 순서대로 정렬
    3. 등장한 횟수가 같다면 먼저 등장한 순서대로 정렬
   */

  public static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] X = br.readLine().split(" ");
    int N = Integer.parseInt(X[0]);
    int C = Integer.parseInt(X[1]);

    String[] arr = br.readLine().split(" ");

    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(arr[i]);
      if (map.containsKey(x)) {
        // key 값으로 가져오기, 키 값이 이미 존재하면 +1 값 해주기
        map.put(x, map.get(x) + 1);
      }
      if (!map.containsKey(x)) {
        map.put(x, 1);
      }
    }
  }

  // 등장 횟수에 대해 정렬하려면, 각 숫자의 횟수와 첫 인덱스를 구해야한다.
  // 주어진 숫자의 범위 C가 최대 10억이기 때문에 Count 배열을 이용해 빈도를 구하는 방법은 메모리가 부족하다.

  public static void solution2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] X = br.readLine().split(" ");
    int N = Integer.parseInt(X[0]);
    int C = Integer.parseInt(X[1]);

    Frequency[] frequencies = new Frequency[N];

    Arrays.sort(frequencies, (o1, o2) -> {
      if (o1.getCount() == o2.getCount()) {
        return o1.getFirstIndex() - o2.getFirstIndex();
      }
      return o2.getCount() - o1.getCount();
    });

//    Arrays.sort(frequencies, new Comparator<Frequency>() {
//      @Override
//      public int compare(Frequency o1, Frequency o2) {
//        if (o1.getCount() == o2.getCount()) {
//          return o1.getFirstIndex() - o2.getFirstIndex();
//        }
//        return o2.getCount() - o1.getCount();
//      }
//    });

    for (Frequency frequency : frequencies) {
      int count = frequency.getCount();
      while (count-- > 0) {
        bw.write(frequency.getNum() + " ");
      }
    }
  }

  public static void solution3() {

    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    Message[] messages = new Message[N];

    for (int i = 0; i < N; i++) {
      // Count가 같을때의 비교 기준을 위해 message에 index를 저장
      messages[i] = new Message(scan.nextInt(), i);
    }

    // 오름차순 정렬
    Arrays.sort(messages, (o1, o2) -> o1.num - o2.num);

    Frequency[] frequencies = new Frequency[N];
    frequencies[0] = new Frequency(messages[0].num, 1, messages[0].idx);
    // freqIdx는 지금 빈도를 세고 있는 인덱스
    int freqIdx = 0;
    for (int i = 1; i < N; i++) {
      if (messages[i].num != messages[i - 1].num) {
        // 새로운 Frequency 객체 생성
        frequencies[++freqIdx] = new Frequency(messages[i].num, 0, messages[i].idx);
      }
      frequencies[freqIdx].setCount(frequencies[freqIdx].getCount() + 1);
    }

    // sort 정렬에 원하는 범위 (fromIndex, toIndex)를 지정할 수 있다. 이렇게 되면 [fromIndex, toIndex] 범위만큼만 정렬된다.
    // freqIdx까지는 유효
    Arrays.sort(frequencies, 0, freqIdx + 1, (o1, o2) -> {
      if (o1.getCount() == o2.getCount()) {
        return o1.getFirstIndex() - o2.getFirstIndex();
      }
      return o2.getCount() - o1.getCount();
    });

    for (Frequency frequency : frequencies) {
      int count = frequency.getCount();
      while (count-- > 0) {
        System.out.print(frequency.getNum() + " ");
      }
      System.out.println();
    }
  }
}