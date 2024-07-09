package Queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10845 {


    // BOJ_10845 정수를 저장하는 큐를 구현하고, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
    // 명령은 총 여섯 가지이다.
    // 1. push X: 정수 X를 큐에 넣는 연산이다.
    // 2. pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    // 3. size: 큐에 들어있는 정수의 개수를 출력한다.
    // 4. empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    // 5. front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    // 6. back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

    // 각각의 Queue 구현체를 통해 그대로 풀 수 있음
    // 단 java.util.Queue는 가장 뒷 원소에 접근하는 기능을 따로 제공하지 않으므로 가장 마지막에 저장된 원소를 따로 저장해두고 해당 값을 출력한다.
    // java 추가 시간이 없으므로 BufferedReader/BufferedWriter를 사용해야 함 (큐의 모든 연산은 O(1))

    public static void main(String[] args) throws IOException {
        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 개수
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int last = -1;
        // 이 모든 연산은 Queue의 연산, 미리 Queue를 구현해두고 연산을 수행한다.
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push" -> {
                    last = Integer.parseInt(cmd[1]);
                    q.offer(last);
                }
                case "pop" -> bw.write(q.isEmpty() ? "-1\n" : q.poll() + "\n");
                case "size" -> bw.write(q.size() + "\n");
                case "empty" -> bw.write(q.isEmpty() ? "1\n" : "0\n");
                case "front" -> bw.write(q.isEmpty() ? "-1\n" : q.peek() + "\n");
                case "back" -> bw.write(q.isEmpty() ? "-1\n" : last + "\n");
            }
            /*
                if (cmd[0].equals("push")) {
                    last = Integer.parseInt(cmd[1]);
                    q.offer(last);
                    // q.add(Integer.parseInt(cmd[1]));
                } else if (cmd[0].equals("pop")) {
                    bw.write(q.isEmpty() ? "-1\n" : q.poll() + "\n");
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else bw.write(q.poll() + "\n");
                } else if (cmd[0].equals("size")) {
                    bw.write(q.size() + "\n");
                } else if (cmd[0].equals("empty")) {
                    bw.write(q.isEmpty() ? "1\n" : "0\n");
                } else if (cmd[0].equals("front")) {
                    // q.element();
                    // q.peek();
                    bw.write(q.isEmpty() ? "-1\n" : q.peek() + "\n");
                } else if (cmd[0].equals("back")) {
                    bw.write(q.isEmpty() ? "-1\n" : last + "\n");
                }
            */
        }
        // Java에서 BufferedWriter와 같은 버퍼링된 출력 스트림을 사용할 때 데이터는 즉시 출력되지 않고 버퍼에 저장됩니다. flush 메서드를 호출하면 버퍼에 있는 모든 데이터를 실제 출력 스트림으로 전송합니다.
        bw.flush();
    }


    // MyQueue를 사용한 풀이
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        MyQueue<Integer> q = new MyQueue<>();

        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push" -> q.enqueue(Integer.parseInt(cmd[1]));
                case "pop" -> bw.write(q.isEmpty() ? "-1\n" : q.dequeue() + "\n");
                case "size" -> bw.write(q.size() + "\n");
                case "empty" -> bw.write(q.isEmpty() ? "1\n" : "0\n");
                case "front" -> bw.write(q.isEmpty() ? "-1\n" : q.getFront() + "\n");
                case "back" -> bw.write(q.isEmpty() ? "-1\n" : q.getRear() + "\n");
            }
        }
        bw.flush();
    }
}
