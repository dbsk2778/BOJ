package Recursion.back_tracking;

import java.util.Arrays;
import java.util.Scanner;

// 전형적인 백트래킹 문제
public class boj_15654 {

    /**
     * 1. 순열(Permutation): 집합 안에서 가능한 모든 조합을 나열하는 것
     * ex. {1, 2, 3} 집합에서 만들 수 있는 순열
     * {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}
     * <p>
     * 2. 특징
     * - 중복이 없는 n 개의 원소 집합에서는 n!개의 순열이 생성됨
     * - 중복된 원소가 있는 경우에는 각 원소의 {중복횟수!}의 곱으로 나눈 값의 개수만큼 순열이 생성됨
     * ex. {1, 1, 2, 2, 2, 3}
     * - n1 = 2!
     * - n2 = 3!
     * - n3 = 1!
     * 순열 = n! / (n1! * n2! * n3!) = 720 / (2 * 6 * 1) = 60
     */

    static int n, m;
    static int[] numbers;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) {
        // 입력 처리
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        check = new boolean[n];
        output = new int[m];  // 뽑을 숫자

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // 사전에 정렬 해놓으면 사전순 정렬됨
        Arrays.sort(numbers);

        // depth 0부터 시작
        perm(0);
    }


    /* 문제 - N과 M (5)
         N개의 자연수 중에서 M개를 고른 수열 - 수열은 사전 순으로 출력 (중복 X, N개의 자연수는 모두 다른 수)
         1. 완전탐색일 경우 시간 복잡도는 (N = 8, M = 8일 경우) 8! = 40,320번 연산 (1초만에 구하기 가능)
         2. 사전 순 출력 : 집합의 숫자를 미리 사전 순으로 정렬하고, 낮은 숫자(인덱스)부터 뽑아서 순열을 생성
         3. 중복되지 않도록 처리하는 방법? N개의 자연수가 모두 다른 수(문제 조건), i 번째 수를 단 한번만 사용하면 됨 (배열을 만들어서 사용 여부 체크)

         수열을 생성하는 방법[0, n]
         - {i번째 수}로 수열 생성이 가능한 경우 :
         더 이상 사용되지 않도록 체크 표시 + 출력을 위해 저장 +
         {i+1 번째 수} 선택을 위해 재귀함수 호출 + {i번째 수}가 다시 사용될 수 있도록 체크 제거

        재귀 종료를 위한 Base Case는 n개의 수에서 m개를 모두 뽑아 수열 생성
        - m개를 모두 뽑은 경우, 수열을 출력하고 종료
        - m개를 뽑지 않은 경우, 다음 수를 뽑기 위해 재귀함수 호출
        - 재귀함수가 (depth == m)인 경우, 수열을 출력하고 종료
    */

    // depth를 점점 증가시키면서 수열을 생성
    private static void perm(int depth) {
        // 재귀 종료를 위한 Base Case
        if (depth == m) {
            // 수열 출력 - 출력할때 하나하나 print 함수를 수행하게 되면 시간초과가 발생할 수 있음
//            for (int i = 0; i <m; i++) {
//                System.out.print(output[i] + " ");
//            }
//            System.out.println();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb);
            return; // perm 함수 반드시 종료 해줘야 함
        }
        // Recursive Case
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                // 이 안에 들어왔다는건 숫자를 뽑았다는걸 의미
                // 사용했다고 check, 다음번에 사용되지 않도록
                check[i] = true;
                // 현재 내가 몇번째 재귀를 호출하고 있는지
                output[depth] = numbers[i];
                perm(depth + 1); // 재귀호출, 이 함수 끝났다는걸 i의 사용이 끝났다!
                // 사용 끝
                check[i] = false;
            }
        }
    }
}
