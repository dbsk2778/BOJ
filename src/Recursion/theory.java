package Recursion;

public class theory {

    /**
     * 재귀함수 : 자기 자신을 호출하는 함수
     * <p>
     * 왜 사용할까?
     * 1. 하나의 커다란 문제를 작은 문제로 나누어 해결
     * 2. 문제를 귀납적으로 생각하기 위해서 {i}번째 답을 구하기 위해 {i-1}, {i-2} ...번째 답을 이용
     * <p>
     * <p>
     * 재귀함수를 잘 설계하는 방법
     * 1. Base Case : 재귀 호출을 끝내는 조건 (계산 없이 바로 답을 구할 수 있는 경우)
     * - 적어도 하나 이상의 Base Case가 있어야 한다.
     * 2. Recursive Case : 자기 자신을 호출하는 부분 (문제를 작은 부분으로 쪼개기 위함)
     * - 함수가 호출될수록 부분 문제가 Base Case에 수렴해야 함
     * 3. 귀납적으로 생각하기 : 큰 문제를 작은 부분 문제로 분할
     * - 부분 문제들은 재귀를 통해 하위 문제를 해결
     * 4. 중복 계산 방지 (memorization) : 이미 계산한 값을 저장하여 중복 계산을 방지
     * - 동일한 계산이 반복될 가능성이 있다면 메모리에 저장(배열, 리스트 등)
     */

    public static void main(String[] args) {
        recursion1(10);
        recursion2(10);
    }

    /*
        재귀 함수 예시 - 숫자 출력
        1. 1부터 N까지 오름차순으로 출력
        2. N부터 1까지 내림차순으로 출력

        * 이 두가지 함수의 차이점은 재귀함수와 출력문의 위치 차이인데,
        이유는 재귀함수가 전부 다 실행되고 출력을 하게 되면 오름차순으로 출력이 되고,
        출력문이 먼저 실행되고 재귀함수가 실행되면 내림차순으로 출력이 된다.

     */


    // 1. 1부터 N까지 오름차순으로 출력 - 순서가 재귀함수 호출 후에 나오게 된다.
    public static void recursion1(int n) {
        if (n == 0) return;  // Base Case
        recursion1(n - 1);  // Recursive Case
        System.out.println(n);
    }

    // 1. N부터 1까지 내림차순으로 출력 - 순서가 재귀 함수 호출 전에 나오게 된다.
    public static void recursion2(int n) {
        System.out.println(n);
        // if (n == 0) return;
        if (n > 1) recursion2(n - 1);
    }


}
