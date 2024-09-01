package Queue.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static Queue<Integer> queue = new LinkedList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int backNumber = -1;
        for (int i = 0; i < n; i++) {
            String oper = br.readLine();

            if (oper.contains("push")) {
                String[] strs = oper.split(" ");
                int num = Integer.parseInt(strs[1]);
                push(num);
                backNumber = num;
            } else if (oper.equals("pop")) {
                bw.write(pop() + "\n");
                if (queue.isEmpty()) { // 큐가 비었다면 backNumber를 초기화
                    backNumber = -1;
                }
            } else if (oper.equals("size")) {
                bw.write(size() + "\n");
            } else if (oper.equals("empty")) {
                bw.write(empty() + "\n");
            } else if (oper.equals("front")) {
                bw.write(front() + "\n");
            } else if (oper.equals("back")) {
                bw.write(backNumber + "\n");
            }
        }
        bw.flush();
    }

    private static void push(int num) {
        queue.add(num);
    }

    private static int pop() {
        if (size() == 0) {
            return -1;
        }
        return queue.remove();
    }

    private static int size() {
        return queue.size();
    }

    private static int empty() {
        if (size() == 0) {
            return 1;
        }
        return 0;
    }

    private static int front() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }
}
