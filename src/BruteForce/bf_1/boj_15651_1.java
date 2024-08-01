package BruteForce.bf_1;

import java.util.Scanner;

public class boj_15651_1 {

    /*
      완전탐색(Exhaustive Search)이란?  ** 부분 점수를 얻기는 좋지만, 시간 복잡도가 일반적으로 높다.
      1. 문제를 해결하기 위해 확인해야 하는 모든 경우를 전부 탐색하는 방법, 그 중에서도 백 트래킹(Back-Tracking)을 통해야 하는 상황을 해결하기
      2. 완전탐색은 모든 경우의 수를 탐색하기 때문에 시간이 오래 걸리는 단점이 있지만, 경우의 수가 적을 때는 강력한 방법이 될 수 있다.
     */
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        // 1번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도
        solution(1);
        System.out.println(sb.toString());
    }

    // 모든 문제에서 접근할 수 있는 방법
    // BOJ_15651 : N과 M (3) : N개의 자연수 중에서 M개를 고른 수열, 같은 수를 여러 번 골라도 된다. (중복 허용)
  /*
    모든 경우의 수는 N^M이다. 시간 복잡도는 O(N^M) : 최악의 경우 82만번 연산 (1억 미만이면 대략 1초)
    Recurrence Function (재귀 함수)
    1. 만약 M개를 전부 고름 --> 조건에 맞는 탐색을 한 가지 성공한 것.
    2. 아직 M개를 고르지 않음 --> k번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도.
  */
    public static void solution(int k) {
        if (k == M + 1) {  // 다 고름
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                // k+1 번지부터 M 번지까지 수를 고르는 모든 방법을 시도
                solution(k + 1);
                selected[k] = 0;
            }
        }
    }
}