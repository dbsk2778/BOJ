package ExhaustiveSearch;

import java.util.Scanner;

public class _10448 {

    // ** 매번 사용하는 값을 한번만 구하도록 !! 이런거 시간 복잡도에 매우 도움이 된다. = 전처리 과정 더하기 **
    // 문제: 삼각수 Tn = n(n+1)/2으로 정의될 때, 주어진 K가 정확히 3개의 삼각수 합으로 표현될 수 있는가?

    // 1. 모든 삼각수를 구하기
    // 2. 주어진 숫자를 세 개의 삼각수의 합으로 표현할 수 있는지 확인한다.
    // 현재 k의 최대 범위가 1000이라는걸 알려줬기 때문에 1000보다 작은 삼각수만 구하면 된다.


    public static void main(String[] args) {
        eureka();
    }

    // 시간 복잡도 O(triangleNumberCount + triangleNumberCount ^ 3)

    static boolean[] isEurekaNumber = new boolean[1001];

    public static void eureka() {
        // [3, 1000] 범위의 삼각수를 구한다.

        // 1. K보다 작은 모든 삼각수를 구한다.
        // 2. 구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인한다.
        preprocessing();
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int K = scan.nextInt();
            System.out.println(isEurekaNumber[K] ? "1" : "0");
        }
    }

    // 시간 복잡도 줄이기 : eureka number도 변하지 않으니 미리 한번에 구해둘 수 있지 않을까?
    // 1000 이상의 수는 구하지 않아도 되지 않을까?
    // 시간 복잡도 O(K * triangleNumberCount) = 44000
    // 만약 K가 계속 커진다면 이 방법이 더 효율적이다.

    public static void preprocessing() {
        // 1. K보다 작은 삼각수를 모두 구한다.
        int[] triangleNumbers = new int[50]; // 임의로 배열 숫자 설정
        int triangleNumberCount = getTriangleNumber(triangleNumbers, 1000);  // 매번 테스트마다 구하지 않기.

        // 2. 구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인한다.
        boolean[] isSumOfTriangle = new boolean[1000];

        for (int i = 0; i < triangleNumberCount; i++) {
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) {
                    isSumOfTriangle[sum] = true;
                }
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (!isSumOfTriangle[i]) {  // 두개의 합으로 나타낼 수 없는 수
                continue;
            }
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = i + triangleNumbers[j];
                if (sum <= 1000) {
                    isEurekaNumber[sum] = true;
                }
            }
        }
    }

    public static int getTriangleNumber(int[] triangleNumbers, int K) {
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {  // i 가 무슨 값인지 아직 모름 !!
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber > K) {
                break;
            }
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }
        return triangleNumberCount;
    }

    // 전수조사
    // 시간복잡도 O (n ^ 3) - 이걸 써도 될까?
    // 현재 k의 범위가 최대 1000이기 때문에, 1000보다 작은 삼각수만 구하면 된다. 결과적으로 44개의 삼각수만 구하면 된다.
    // 44 * 44 * 44 = 85184 : 10만도 안되기 때문에 전수조사로 풀어도 된다.

    // 시간 복잡도 줄이기 : eureka number도 변하지 않으니 미리 한번에 구해둘 수 있지 않을까?
    public static boolean isEureka(int[] triangleNumbers, int triangleNumberCount) {
        for (int i = 0; i < triangleNumberCount; i++) {
            for (int j = 0; j < triangleNumberCount; j++) {
                for (int k = 0; k < triangleNumberCount; k++) {
                    // 아래 sum은 1000 + 1000 + 1000 = 3000이기 때문에 K의 최댓값이 1000이므로 반복을 줄ㄹ일 수 있다.
                    int sum = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];

                    if (sum == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
