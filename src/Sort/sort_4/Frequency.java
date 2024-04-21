package Sort.sort_4;

public class Frequency {

  // 만약 setter을 안쓰면 final로 선언해도 된다.
  private int num;
  private int count;
  private int firstIndex;

  public Frequency(int num, int count, int firstIndex) {
    this.num = num;
    this.count = count;
    this.firstIndex = firstIndex;
  }

  public int getNum() {
    return num;
  }

  public int getCount() {
    return count;
  }

  public int getFirstIndex() {
    return firstIndex;
  }

  public int setNum(int num) {
    return this.num = num;
  }

  public int setCount(int count) {
    return this.count = count;
  }

  public int setFirstIndex(int firstIndex) {
    return this.firstIndex = firstIndex;
  }
}


//public record Frequency(int num, int count, int firstIndex) {

// record는 기본적으로 final이기 때문에 setter가 없다. (불변성 보장)
// class는 setter를 통해 값을 변경할 수 있지만, record는 생성자를 통해서만 값을 변경할 수 있다.
//}

/*
// Record 예시
record Point(int x, int y) {}

// Class 예시
class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // getter, setter, equals(), hashCode(), toString() 등을 직접 정의해야 함
}


 */
