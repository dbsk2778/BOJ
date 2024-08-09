package Recursion.fibo;

import java.util.HashMap;
import java.util.Map;

public class boj_2747 {

    /**
     * 피보나치 수: n번째 피보나치 수를 구하여라.
     */

    public static void main(String[] args) {
        System.out.println(fibo(10));
        // 한 번 계산된 값을 저장해두면 재활용할 수 있음
        System.out.println(fiboWithMap(10));
        System.out.println(fiboWithArray(10));
    }


    // 종료 조건, n이 1이거나 2이면 1을 반환 - 이건 시간 초과가 발생함 (메모리 많이 사용됨)
    public static int fibo(int n) {
        if (n == 1 || n == 2) return 1;  // Base Case (계산없이 바로 답을 구할수 있음)
        // n번째 피보나치 수 = n-1번째 피보나치 수 + n-2번째 피보나치 수
        return fibo(n - 1) + fibo(n - 2); // Recursive Case
    }

    private static final Map<Integer, Integer> fibos = new HashMap<>();

    // Map을 이용한 피보나치 수 계산
    public static int fiboWithMap(int n) {
        if (n == 1 || n == 2) return 1;  // Base Case (계산없이 바로 답을 구할수 있음)
        if (fibos.containsKey(n)) return fibos.get(n); // 이미 계산한 값이면 저장된 값을 반환

        // n번째 피보나치 수 = n-1번째 피보나치 수 + n-2번째 피보나치 수
        int value = fiboWithMap(n - 1) + fiboWithMap(n - 2); // Recursive Case
        fibos.put(n, value); // 계산한 값을 저장
        return value;
    }

    // 배열을 이용한 피보나치 수 계산 - n은 45보다 작은 자연수라는 조건 있음
    private static final int[] fiboArray = new int[50];

    public static int fiboWithArray(int n) {
        if (n == 1 || n == 2) return 1;
        if (fiboArray[n] != 0) return fiboArray[n];

        fiboArray[n] = fiboWithArray(n - 1) + fiboWithArray(n - 2);
        return fiboArray[n];
    }
}
