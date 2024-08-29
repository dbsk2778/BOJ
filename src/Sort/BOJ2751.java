package Sort;

import Sort.sort_1.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        // dualPivotQuickSort();

        reverseSort();
        reverseSort2();

        example();
    }

    // 최대 백만개 정수니까 N2 알고리즘은 시간 초과 뜸
    // 자바의 int, double 같은 primitive 타입은 Dual-Pivot Quick Sort
    // Arrays.sort()의 시간 복잡도는 최소 NlogN에서 최대 N2임 -> 시간 복잡도 중요
    public static void dualPivotQuickSort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N - 1; i++) {
            sb.append(numbers[i]).append("\n");
        }
        sb.append(numbers[N - 1]);

        System.out.println(sb);
    }

    // 자바의 Wrapper Class Integer, String 이런건 Tim Sort 사용하므로
    // Arrays.sort()의 시간 복잡도가 NlogN으로 보장됨 (최대도 NlogN)
    public static void timSort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Integer[] numbers = new Integer[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N - 1; i++) {
            sb.append(numbers[i]).append("\n");
        }
        sb.append(numbers[N - 1]);

        System.out.println(sb);
    }

    // 기본 오름차순이 아닌, 내림차순 정렬을 하고 싶다면?
    public static void reverseSort() {
        int[] primitiveArray = {6, 5, 1, 8, 10, 334, 9, 11};

        Arrays.sort(primitiveArray);

        // 오름차순 정렬 후 거꾸로 출력
        for (int i = primitiveArray.length - 1; i >= 0; i--) {
            System.out.println(primitiveArray[i]);
        }
    }

    public static void reverseSort2() {
        // Wrapper Class 사용하면 아래와 같이 사용 가능
        Integer[] objectArray = {6, 5, 1, 8, 10, 334, 9, 11};

        // Collections.reverseOrder() 사용해서 내림차순 정렬 가능
        // 람다로도 변형 가능 (o1, o2) -> o2 - o1
        Arrays.sort(objectArray, Collections.reverseOrder());

        for (Integer x : objectArray) {
            System.out.println(x);
        }
    }

    // 기본 제공되는 타입이 아닌 내가 정의한 클래스를 정렬하고 싶다면?
    public static void example() {
        Student[] students = {new Student("Alice", 20),
                new Student("Yuna", 22),
                new Student("David", 23),
                new Student("Bob", 19)};

        // 정렬을 하기 위해서는 두 원소를 비교해야 하는데,
        // 단순히 Arrays.sort()만 사용하게 되면 Student Class의 정렬 기준을 알 수 없음
        // Arrays.sort(students); // 이렇게만 사용하면 런타임 에러뜸

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() == o2.getAge()) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getAge() - o2.getAge();
            }
        });

        // 위의 Comparator 구현을 람다 식으로 변경
        Arrays.sort(students, (o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getAge() - o2.getAge();
        });

        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge());
        }

    }
}
