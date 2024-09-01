package TwoPointer.BOJ2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003_BinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        long[] acc = new long[N + 1];

        for (int i = 1; i <= N; i++) acc[i] = acc[i - 1] + sequence[i];

        System.out.println(binarySearch(N, M, acc));
    }

    // O(NlogN)이라서 O(N2)인 이중 for문보다 효율적
    public static int binarySearch(int N, int M, long[] acc) {
        int count = 0;
        // 시작 위치는 한 바퀴 돌아야 함
        for (int i = 1; i <= N; i++) {
            int left = i;
            int right = N;

            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = acc[mid] - acc[i - 1];

                if (sum > M) right = mid - 1;
                else if (sum < M) left = mid + 1;
                else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
