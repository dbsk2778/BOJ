package Queue;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj_1158 {

    public static void main(String[] args) throws Exception {
        solution2(7, 3);
        solution();
    }

    // Queue 사용 - 이 문제는 원형 구조이기 때문에 Queue로 하는게 쉽게 구현 가능
    // 큐의 앞에서 요소를 제거하고 다시 큐의 뒤에 추가함으로써 사연스럽게 원형 순환을 처리할 수 있음
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i); // queue.add()와 동일
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (q.size() != 1) {
            // 큐의 앞에서 K-1번째까지의 요소를 큐의 뒤로 이동
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(",");
        }
        // while문을 빠져나오면 큐에는 마지막 요소만 남아있음
        sb.append(q.poll()).append(">");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    // List 사용
    public static void solution2(int N, int K) {
        List<Integer> orders = new ArrayList<>();
        List<Integer> people = new ArrayList<>();

        // 1부터 N까지 리스트에 넣는다
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        int index = 0;  // 현재 제거할 사람의 인덱스

        while (!people.isEmpty()) {
            index = (index + K - 1) % people.size();  // K번째 사람의 인덱스를 계산
            orders.add(people.remove(index));  // K번째 사람을 제거하고 리스트에 추가
        }

        System.out.println(orders);
    }
}
