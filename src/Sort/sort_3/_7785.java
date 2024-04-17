package Sort.sort_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _7785 {

  public static void main(String[] args) throws IOException {
    mapSolution();
    n2solution();
    arraySolution();
    treeSetSolution();
  }

  // 회사 출입 기록이 주어질 때, 아직 퇴근하지 못한 사람의
  // 퇴근했던 사람이 다시 출근할 수도 있음
  public static void mapSolution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    // map은 중복을 허용하지 않음
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] member = br.readLine().split(" ");
      String name = member[0];
      String status = member[1];

      // enter 상태인경우 map에 추가
      if (status.equals("enter")) {
        map.put(name, "enter");
      } else {  // leave 상태인경우 map에서 제거 : map.remove(key)
        map.remove(name);
      }
    }

    List<String> currentEmployees = new ArrayList<>(map.keySet());
    currentEmployees.sort(Collections.reverseOrder());

    for (String employee : currentEmployees) {
      bw.write(employee + "\n");
    }

    bw.flush();
  }

  // 이렇게 하게 되면 시간복잡도가 N^2이 되어서 시간초과가 발생
  public static void n2solution() {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();

    String[] inCompany = new String[N];
    int inCompanyIndex = 0;

    for (int i = 0; i < N; i++) {
      String name = scan.next();
      String status = scan.next();

      if (status.equals("enter")) {
        inCompany[inCompanyIndex++] = name;
      }
      if (status.equals("leave")) {
        for (int j = 0; j < inCompanyIndex; j++) {
          if (inCompany[j].equals(name)) {
            inCompany[j] = "";
            break;
          }
        }
      }
    }
  }

  // 각 사원의 기록을 차례로 봤을 때, 마지막 기록이 enter라면 아직 회사에 남아있다.
  // 1. 이름 순서에 따라 출입기록을 차례로 정렬한다.
  // 2. 각 사원마다 마지막 기록이 enter인지 확인한다.
  // 3. enter라면 회사에 남아있는 것이므로 출력한다.
  public static void arraySolution() {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    String[][] records = new String[N][2];

    for (int i = 0; i < N; i++) {
      records[i][0] = scan.next();
      records[i][1] = scan.next();
    }

    // 어차피 역순으로 출력할것이기 때문에 역순으로 정렬
    // stable sort 이므로, 이름이 같은 경우에는 기존의 순서를 유지한다. 결과적으로 출입 순서가 섞이지 않는다. = String에 대한 정렬은 사전순으로 정렬된다.
    Arrays.sort(records, new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
//        return o1[0].compareTo(o2[0]); // 사전순 정렬
        return o2[0].compareTo(o1[0]); // 역순 정렬
      }
    });

    // 이미 name으로 정렬된 상태이므로 연속된 두 기록을 비교하면 된다.
    for (int i = 0; i < N - 1 ; i++) {
      if (records[i][1].equals("enter") && records[i][0].equals(records[i + 1][0])) {
        System.out.println(records[i][0]);
      }
    }
    // 위 코드가 N-2까지만 돌기 때문에 마지막 사람은 따로 처리해줘야함, 이미 정렬되어있기 때문에 더 이상의 기록은 없으므로 enter라면 회사에 남아있는 것이다.
    if (records[N - 1][1].equals("enter")) {
      System.out.println(records[N - 1][0]);
    }
  }

  // 시간복잡도 o(N * logN)
  public static void treeSetSolution() {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();

    Set<String> entered = new TreeSet<>();  // 이미 사전순으로 정렬되어있음

    for (int i = 0; i < N; i++) {
      String name = scan.next();
      String status = scan.next();

      if (status.equals("enter")) {
        entered.add(name);  // 집합에 추가
      } else {
        entered.remove(name);  // 집합에서 제거
      }
    }

    // String 배열로 변환
    String[] orderedAnswer = entered.toArray(new String[entered.size()]);
    for (int i = orderedAnswer.length - 1; i >= 0; i--) {  // 거꾸로 출력 (역순)
      System.out.println(orderedAnswer[i]);
    }
  }
}
