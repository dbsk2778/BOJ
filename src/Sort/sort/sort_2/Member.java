package Sort.sort.sort_2;

public class Member implements Comparable<Member> {
  private final int index;
  private final int age;
  private final String name;

  public Member(int index, int age, String name) {
    this.index = index;
    this.age = age;
    this.name = name;
  }

  public int getIndex() {
    return this.index;
  }

  public int getAge() {
    return this.age;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int compareTo(Member o) {
    if (this.age != o.age) {
      return this.age - o.age;
    } else {
      return this.index - o.index;
    }
  }
}
