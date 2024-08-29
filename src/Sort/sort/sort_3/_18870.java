package Sort.sort.sort_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class _18870 {

  // N개의 좌표가 주어질 때, 각 좌표가 입력된 좌표 중 몇번째 좌표인지 출력

  // 1. 입력된 좌표를 작은 순으로 정렬한다.
  // 2. 정렬된 좌표를 중복을 제거하며 압축된 인덱스를 기록한다.
  // 3. 입력된 좌표에 알맞은 압축 인덱스를 출력한다.

  public static void main(String[] args) throws IOException {
    solution();
    solution2();
    solution3();
  }

  // 단순 구현 : 시간초과
  public static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] arr = br.readLine().split(" ");

    int[] xs = new int[N];
    Arrays.sort(arr); // 얘는 숫자 순서대로 정렬됨

    int idx = 0;
    // 압축된 인덱스 저장
    int[] nthX = new int[N];
    nthX[idx++] = xs[0];

    for (int i = 1; i < N; i++) {
      if (xs[i] != xs[i - 1]) {
        nthX[idx++] = xs[i];
      }
    }
    // 시간초과 발생
    for (int i = 0; i < N; i++) {
      findValueIndex(nthX, xs[i]);
    }
    bw.flush();
  }

  // 단순구현 시간복잡도 : O(N) / 전체 시간복잡도 : O(N^2)
  public static void findValueIndex(int[] nthX, int x) {
    for (int i = 0; i < nthX.length; i++) {
      if (nthX[i] == x) {
        System.out.println(i);
        break;
      }
    }
  }

  // 좌표와 그 좌표가 몇 번째 입력인지를 같이 저장
  // 전체 시간 복잡도 : O(NlogN)
  public static void solution2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    // x(들어온 숫자), y(들어온 순서, 인덱스)
    int[][] xs = new int[N][2];

    for (int i = 0; i < N; i++) {
      xs[i][0] = Integer.parseInt(br.readLine());
      xs[i][1] = i;
    }

    // x를 기준으로 정렬 (int[] 값) - 입력된 좌표를 작은 순으로 정렬, 0번 인덱스 = 입력된 숫자 기준 정렬
    // 오름차순 정렬
//    Arrays.sort(xs, new Comparator<int[]>() {
//      @Override
//      public int compare(int[] o1, int[] o2) {
//        return o1[0] - o2[0];
//      }
//    });

//    Arrays.sort(xs, (o1, o2) -> o1[0] - o2[0]);
    Arrays.sort(xs, Comparator.comparingInt(o -> o[0]));

    // 정렬된 좌표를 중복을 제거하며 압축된 인덱스를 기록한다.
    // 이 떄 ans의 해당 좌표의 압축 인덱스를 저장한다.
    int[] ans = new int[N];
    int idx = 0;
    ans[xs[0][1]] = idx;
    for (int i = 1; i < N; i++) {
      // 이전 좌표랑 지금 좌표랑 다를때만 압축 좌표의 idx 증가
      if (xs[i][0] != xs[i - 1][0]) {
        idx++;
      }
      // 해당 좌표의 압축 인덱스를 저장 (원래는 input 순서)
      ans[xs[i][1]] = idx;
    }

    // 구해진 압축 인덱스 출력 (ans 배열)
    for (int i = 0; i < N; i++) {
      bw.write(ans[i] + " ");
    }
    bw.flush();
  }

  /*
    TreeSet, Set, Map을 이용한 풀이
      1. 입력된 좌표를 작은 순으로 정렬한다. (TreeSet 순회)
      2. 정렬된 좌표를 중복을 제거하며 압축된 인덱스를 기록한다. (Set 중복제거)
      3. 입력된 좌표에 알맞은 압축 인덱스를 출력한다. (Map)
   */
  // 시간복잡도 : O(NlogN)
  public static void solution3() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] xs = new int[N];

    // TreeSet은 요소를 삽입할 때 자동으로 정렬됨 (오름차순) + 중복도 제거됨
    Set<Integer> set = new TreeSet<>(); // ordered collection

    // 동시에 int[] 배열에도 저장해주고, 중복을 제거하기 위해 Set에도 저장해줌
    for (int i = 0; i < N; i++) {
      xs[i] = Integer.parseInt(br.readLine());
      set.add(xs[i]);
    }

    // 중복이 제거된 값에서 압축된 인덱스 저장
    // x: 입력된 값 / idx: 압축된 인덱스
    Map<Integer, Integer> sortedIndex = new HashMap<>();
    int idx = 0;
    // 작은 값부터 순회
    for (int x : set) {
      sortedIndex.put(x, idx++);
    }

    for (int i = 0; i < N; i++) {
      // 키 값으로 압축된 인덱스 가져오기
      bw.write(sortedIndex.get(xs[i]) + " ");
    }
  }
}
