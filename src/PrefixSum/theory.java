package PrefixSum;

public class theory {

    /*
     * 구간합 문제 - 수 N개가 주어졌을 때, M번의 (i, j) 질문에 대해 i번째 수부터 j번째 수까지 합을 구하는 문제
     * (연속적인 수의 합을 구함 !!) = 수들의 나열에서 특정 구간의 합 구하기 
     *
     * accumulate = 누적합 배열의 시간 복잡도는 O(N)
     * 누적 합 배열 : acc[i] = Sum(arr[1], arr[i]) : 1번째 수부터 i번째 수까지 더함
     * acc[0] 값은 X : 누적합을 구할때 인덱스를 0부터 시작하기보다는 1부터 시작하는게 더 좋음
     * 0부터 시작하게 되면 아래의 a - 1을 해줄 때 인덱스가 1이상일 경우로 에러 처리 해줘야 함
     *
     * Q(a, b) : 누적합 배열을 사용한 (a, b)의 누적합 구하기
     * (a, b)의 범위의 구간합은 1부터 r까지의 누적합에서 범위에 포함되지 않는 1부터 a - 1까지의 누적합을 뺀 것과 같다.
     *
     * 언제 사용하는 게 좋을까?
     * 구간합을 계산하는 쿼리가 M번, 배열 원소를 갱신하는 쿼리가 K번 주어질 때,
     * 만약 배열의 원소를 갱신하는 쿼리가 같이 들어온다면, 누적합을 사용해도 시간 복잡도가 개선되지 않을 수 있음
     *
     * 구간 합은 배열의 값이 바뀌지 않는 경우에 사용하는게 효율적 (배열의 원소를 갱신하는 쿼리가 있으면 누적합이 정답이 아닐 수 있다.)
     */

    // 누적합 배열은 구간합 연산뿐만 아니라 [a, b] 구간의 연산 결과를 위해
    // [1, b] 연산에서 [1, a - 1] 구간의 연산을 제거하는
    // 복원 작업이 가능한 다른 종류의 연산에도 적용할 수 있음
    // 복원 작업이란 교환법칙, 결합법칙이 성립하며 역원(+a를 하고 -a를 하면 복원 가능)이 존재하는 연산은 복원이 가능
    // 구간 XOR 연산 (XOR(arr[a], arr[b]) = acc[a] ^ acc[a-1])
    // 구간 곱셈 연산 (MULT(arr[a], arr[b]) = acc[b] / acc[a-1]);


    public static void makePrefixSum(int[] arr, int N) {
        int sum = 0;
        int[] acc = new int[N];
        for (int i = 1; i <= N; i++) {
            sum += arr[i];
            acc[i] = sum;
        }
    }

    public static void makePrefixSum2(int[] arr, int N) {
        int[] acc = new int[N];
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + arr[i];
        }
    }

}
