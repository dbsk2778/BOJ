package Sort.sort_1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _2751 {

    // 최대 1,000,000개의 정수를 오름차순 정렬하는 문제 : N^2 알고리즘은 시간초과가 발생, NlogN 알고리즘을 사용해야함
    public static void main(String[] args) throws IOException {
        sortNumbers();
        sortNumbers2();

        // 기본 오름차순이 아닌, 내림차순 정렬을 하고 싶다면?
        decendingSortNumbers();

        // 생성 클래스 정렬
        sortAnyObject();
        sortAnyObject2();
    }

    public static void sortNumbers() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        // 최악 시간복잡도 N^2
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    // 100만개 입력이면 Scanner보다 BufferedReader가 더 빠름, 반드시 이걸 써야 함. (하지만 시간 초과 나올 수 있음) = tim sort 사용해야 함 = object[] sort = 최악의 시간 복잡도 NlogN
    public static void sortNumbers2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // int N = Integer.parseInt(br.readLine());   // primitive[] sort
        int N = Integer.parseInt(br.readLine());  // Integer로 생성해주면 Tim Sort임

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }

    public static void decendingSortNumbers() {
        // 오름차순 정렬 후 거꾸로 출력
        int[] primitiveArray = {6, 2, 4, 8, 6, 1, 9, 10, 3, 7, 5};
        Arrays.sort(primitiveArray);

        for (int i = primitiveArray.length - 1; i >= 0; i--) {
            System.out.println(primitiveArray[i]);
        }

        // Collections.reverseOrder() 사용해서 내림차순 정렬
        // object 정렬일 경우 comparator를 전달할 수 있다.
        Integer[] objectArray = {6, 2, 4, 8, 6, 1, 9, 10, 3, 7, 5};
        // Arrays.sort(objectArray, (o1, o2) -> o2 - o1); // 아래와 동일 (람다식 사용 가능, 내림차순), 오름차순은 o1 - o2
        Arrays.sort(objectArray, java.util.Collections.reverseOrder());
        for (Integer num : objectArray) {
            System.out.println(num);
        }
    }

    // 기본 제공되는 type이 아닌 내가 정의한 클래스를 정렬하고 싶다면?
    public static void sortAnyObject() {
        // Score 클래스를 정렬하고 싶다면?
        Student[] students = {new Student("yuna", 29), new Student("mini", 25),
                new Student("jimin", 27)};
        // Arrays.sort(students); // Comparable 구현해야함, 정렬 기준이 무엇인지 알 수 없기 때문에
        Arrays.sort(students); // 이름순으로 정렬 (Student 클래스에 Comparable 구현하기)
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge());
        }
    }

    public static void sortAnyObject2() {
        // Score 클래스를 정렬하고 싶다면?
        Student[] students = {new Student("yuna", 29), new Student("mini", 25),
                new Student("jimin", 27)};

        // Comparator를 사용하면 정렬 기준을 알 수 있음
        // 코드에 직접 구현
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() == o2.getAge()) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getAge() - o2.getAge();
            }
        });

        // 람다식
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
