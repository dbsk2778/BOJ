package Sort.sort_3;

import java.util.HashMap;
import java.util.Map;

public class mapExample {

  // Map을 이용한 풀이
  // 중복된 키를 가지지 않고, key: value의 쌍을 담는 컬렉션
  // put, remove, containsKey: o(1) ~ o(log(size))의 시간복잡도를 가진다.

  /**
   * HashMap
   * 해시 테이블을 기반으로 한 unordered collection (순서가 없다)
   * 삽입 / 삭제 / 조회 연산: O(1)(기대), null 저장 가능
   * Key의 순서가 보장되지 않음
   *
   * TreeMap
   * 이진 검색 트리(Binary Search Tree)를 기반으로 한 ordered collection (순서를 가짐)
   * 삽입 / 삭제 / 조회 연산: O(logN), null 저장 불가능
   * Key의 순서가 보장됨
   */
  public static void main(String[] args) {
    hashMapExample();
  }

  public static void hashMapExample() {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);
    map.remove("a");
    map.put("d", 4);
    map.put("d", 44);
    System.out.println(map.get("d"));  // 이미 존재한다면 값을 덮어 씌움

    System.out.println(map.size());
    System.out.println(map.containsKey("b"));  // true
    System.out.println(map.containsKey("a"));  // false

    map.remove("e");  // 존재하지 않는 key를 삭제하려고 하면 아무런 변화가 없음
    map.remove("d");
    System.out.println(map.size());  // 2
  }
}
