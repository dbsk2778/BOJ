package Queue;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class boj_1158 {

    public static void main(String[] args) throws Exception {
        solution2();
//        solution();
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
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i); // queue.add()와 동일
        }

        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                q.add(q.poll());
            }
            ans[i] = q.poll();
        }

        System.out.println("<" + Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")) + ">");
    }
}
