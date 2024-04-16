package Sort.sort_3;

import java.util.HashSet;
import java.util.Set;

public class hashSetExample {

  public static void main(String[] args) {
    example();
  }

  // 삽입 삭제 연산이 빠른 집합 자료구조가 존재한다. HashSet
  // HashSet은 중복을 허용하지 않는다. add, remove, contains 연산이 O(1) ~ o(logN)의 시간복잡도를 가진다.
  // Set<Object> set = new HashSet<>();
  public static void example() {
    Set<String> set = new HashSet<>();
    set.add("hello");
    set.add("world");
    set.add("no");
    set.remove("no");
    set.add("hello");  // 이미 존재한다면 추가되지 않음
    set.add("java");
    set.add("hi");

    System.out.println(set.size());
    System.out.println(set.contains("hello")); // true
    System.out.println(set.contains("no")); // false

    set.remove("hello");
    System.out.println(set.size()); // 3
  }
}
