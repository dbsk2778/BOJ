package Sort.sort.sort_1;

public class Student implements Comparable<Student> {

    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }


    // 생성한 클래스의 정렬을 위해 Comparable 인터페이스를 구현해야 함
    // 나이가 작을수록, 나이가 같을 경우 이름이 사전순으로 앞서는 순서로 정렬
    // 나와 쟤(파라미터로 들어온 값)를 비교
    @Override
    public int compareTo(Student o) {
        if (this.age == o.age) {
            return this.name.compareTo(o.name);
        }
        return this.age - o.age;
    }
}
