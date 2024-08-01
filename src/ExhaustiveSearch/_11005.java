package ExhaustiveSearch;

import java.util.Scanner;

public class _11005 {

    // 완전 탐색 - 시뮬레이션
    public static void main(String[] args) {
        _11005_1();
        _11005_2();
    }

    // 진법 변환 2
    // 10진수 N이 주어질 때, 이를 B진법으로 바꿔 출력하라.
    // B진법이라고 했을 때, 각각 자리값에 나타날 수 있는 숫자는 0부터 B-1까지이다. ex. 2진수는 0과 1로만 이루어져있다.
    // 100을 2진법으로 나타내려면 2의 멱수로 분해해야한다. 100에 들어갈 수 있는 가장 큰 수는 2^6안 64이다.
    // 100 = 2^6 * 1 + 2^5 * 1 + 2^4 * 0 + 2^3 * 0 + 2^2 * 1 + 2^1 * 0 + 2^0 * 0

    // 1. X = 100을 2진법으로 나타냈을 때, 가장 큰 자릿수 지수 K를 찾는다. 2^6 = 64 <= 100 < 2^7 = 128 (K는 6, 100은 2진법으로 K+1 자릿수)
    // 2. X에 들어갈 수 있는 2^k항의 자릿값 D를 구한다 = D * 2^k <= X < (D+1) * 2^k  (2^k항의 자릿값은 D) , D = X / 2^k (몫)
    // 3. 2로 돌아가 다음 자릿수를 구한다. 이 때 다음에 구할 자리수의 표현 범위를 제외한다. X => X - D * 2^k = X % 2^k , K => K - 1

    // 100을 36진법으로 나타냈을 때?
    // 1. 36^1 = 36 <= 100 < 36^2 = 1296 (K = 1, 100은 36진법으로 2자릿수)
    // 2. 100 / 36 = 2 ... 28 (D = 2)
    // 3. 28을 36진법으로 나타내기
    public static void _11005_1() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int B = scan.nextInt();

        StringBuilder answer = new StringBuilder();
        while (N > 0) {
            int digit = N % B;
            if (digit < 10) {
                answer.append(digit);
            } else {
                answer.append((char) (digit - 10 + 'A'));
            }
            N /= B;
        }

        // 가장 작은(뒷)자리수의 자릿값부터 구했기 때문에 반대로 출력하기
        for (int i = answer.length() - 1; i >= 0; i--) {
            System.out.print(answer.charAt(i));
        }
    }

    // 1. X를 B로 나눈 나머지를 구하고, B로 나눈다. 0이 될때까지 반복한다.
    // 2. 가장 마지막 나머지부터 가장 앞 자리값이 된다.
    // 시간 복잡도 O(logN)
    public static void _11005_2() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int B = scan.nextInt();

        StringBuilder answer = new StringBuilder();
        while (N > 0) {
            int digit = N % B;  // 나머지
            if (digit < 10) {
                answer.append(digit);
            } else {
                answer.append((char) (digit - 10 + 'A'));  // 10진수 이상일 때는 문자로 변환
            }
            N /= B;  // 몫 (B로 나눈 몫)
//      System.out.println(N);
        }

        // 가장 작은(뒷)자리수의 자릿값부터 구했기 때문에 반대로 출력하기
        for (int i = answer.length() - 1; i >= 0; i--) {
            System.out.print(answer.charAt(i));
        }
    }

}
