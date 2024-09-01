package Stack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10828 {

//    static Deque<Integer> deque = new LinkedList<>();

    // 강의에서는 ArrayDeque 사용
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
//        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");

            switch (strs[0]) {
                case "push":
                    push(Integer.parseInt(strs[1]));
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(isEmpty() + "\n");
                    break;
                case "top":
                    bw.write(top() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }

    // StringBuilder 사용 예제
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");

            switch (strs[0]) {
                case "push":
                    push(Integer.parseInt(strs[1]));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(isEmpty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    // 자바 12부터 사용 가능
    private static void switchExample(BufferedWriter bw, String[] strs) throws IOException {

        switch (strs[0]) {
            case "push" -> {
                push(Integer.parseInt(strs[1]));
            }
            case "pop" -> {
                bw.write(pop() + "\n");
            }
            case "size" -> {
                bw.write(size() + "\n");
            }
            case "empty" -> {
                bw.write(isEmpty() + "\n");
            }
            case "top" -> {
                bw.write(top() + "\n");
            }
        }
    }

    private static void push(int n) {
        // addFirst() 사용시 pop()에서 removeFirst() 사용하면 됨
        deque.addLast(n);
    }

    private static int pop() {
        if (isEmpty() == 0) {
            return deque.removeLast();
        }
        return -1;
    }

    private static int size() {
        return deque.size();
    }

    private static int isEmpty() {
        if (deque.isEmpty()) return 1;
        return 0;
    }

    private static int top() {
        if (isEmpty() == 0) {
            return deque.getLast();
        }
        return -1;
    }

}
