package TwoPointer.BOJ2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003_For {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) sequence[i] = Integer.parseInt(st.nextToken());

        System.out.println(enhancedForSolution(N, M, sequence));

    }

    // 3중 for문 -- 시간초과
    // for문은 브루트포스
    public static int forSolution(int N, int M, int[] sequence) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += sequence[j];
                }

                if (sum == M) count++;
                else if (sum > M) break;
            }
        }
        return count;
    }

    // 2중 for문
    public static int enhancedForSolution(int N, int M, int[] sequence) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += sequence[j];

                if (sum == M) count++;
                else if (sum > M) break;
            }
        }

        return count;
    }
}
