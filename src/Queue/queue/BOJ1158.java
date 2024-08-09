package Queue.queue;

import java.io.*;
import java.util.*;

public class BOJ1158 {

    // 큐로 하는것보다 리스트로 하는게 훨씬 빠름
    public static void main(String[] args) throws IOException {
        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) q.offer(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (q.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> l = new ArrayList<>();

        for (int i = 1; i <= N; i++) l.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;

        while (l.size() != 1) {
            index = (index + (K - 1)) % l.size();
            sb.append(l.remove(index)).append(", ");
        }
        sb.append(l.remove(0));
        sb.append(">");

        System.out.println(sb);
    }
}
