package BruteForce.bf_2;

import java.util.Scanner;

public class boj_14888_2 {

    static int N, max, min;
    static int[] nums, operators, order;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        nums = new int[N + 1];
        operators = new int[5]; // +, -, *, /
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operators[i] = scanner.nextInt();
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    // order[1...N-1] 배열에 연산자들을 순서대로 저장
    // k-1 번째까지 수식을 계산한 결과가 value
    static void rec_func(int k, int value) {
        // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
        if (k == N) {
            // 정한 연산자 순서대로 계산해서 정답 갱신
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else { // k벉째 연산자는 무엇을 선택할것인가?
            // 4가지의 연산자들 중에 뭘 쓸것인지를 선택하고 재귀호출
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k + 1, calculate(value, nums[k + 1], cand));
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    // 피연산자 2개와 연산자가 주어졌을때 계산
    static int calculate(int operand1, int operand2, int operator) {
        if (operator == 1) {
            return operand1 + operand2;
        }
        if (operator == 2) {
            return operand1 - operand2;
        }
        if (operator == 3) {
            return operand1 * operand2;
        }
        if (operator == 4) {
            return operand1 / operand2;
        }
        return 0;
    }
}
