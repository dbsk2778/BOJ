package BruteForce.bf_1;

import java.util.Scanner;

public class boj_15649_2 {

  /*
    BOJ 15649 : N과 M (1)
    문제: 자연수 N과 M이 주어졌을 때, 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 모두 구하는 프로그램을 작성하시오.
   */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] selected = new int[M];
        boolean[] visited = new boolean[N + 1];
//    solution(N, M, selected, visited, 0);
        solution2(N, M, selected, visited, 0);
        System.out.println(sb.toString());
    }

    public static void solution(int N, int M, int[] selected, boolean[] visited, int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int cand = 1; cand <= N; cand++) {
            if (!visited[cand]) {
                visited[cand] = true;
                selected[k] = cand;
                solution(N, M, selected, visited, k + 1);
                visited[cand] = false;
            }
        }
    }

    // StringBuilder 사용
    static StringBuilder sb = new StringBuilder();

    public static void solution2(int N, int M, int[] selected, boolean[] visited, int k) {

        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        }
        for (int cand = 1; cand <= N; cand++) {
            if (!visited[cand]) {
                visited[cand] = true;
                selected[k] = cand;
                solution2(N, M, selected, visited, k + 1);
                visited[cand] = false;
            }
        }
    }
}
