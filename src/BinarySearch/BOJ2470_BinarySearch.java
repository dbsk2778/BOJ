package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_BinarySearch {
    // 음수에서 두개, 양수에서 두개 이렇게 뽑을수도 있음 !!
    public static void main(String[] args) throws IOException {
        solution();
    }

    // 시간 복잡도 O(NlogN)
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answerAbs = Math.abs(arr[0] + arr[1]);
        int answer1 = arr[0];
        int answer2 = arr[1];

        // 전체 용액 중 0과 가장 가까운 value 값 찾기
        for (int i = 0; i < N - 1; i++) {
            // 배열, 찾는 범위(from, to), 첫번째 용액
            int pairValue = findOptimalPair(arr, i + 1, N - 1, arr[i]);
            // i번째 값(value)과 value에 대한 최적값인 pairValue값을 더해서 확인해줘야함
            int sumAbs = Math.abs(arr[i] + pairValue);

            // 두 용액의 합이 0에 가장 가까운 쌍을 저장
            if (answerAbs > sumAbs) {
                answerAbs = sumAbs;
                answer1 = arr[i];
                answer2 = pairValue;
            }
        }

        // 모든 용액에 대한 최적쌍 확인이 끝남
        System.out.println(answer1 + " " + answer2);
    }

    // array에서 value와 쌍이 되는 최적값을 구해라 단순히 같은 값 있는지 찾는 로직과는 다름)
    // 단순히 value 값 하나에 대한 optimalPairValue의 값을 구하는거임
    // 첫 번째 용액에 대해 최적쌍이 되는 두번째 용액을 찾는 로직 !!
    public static int findOptimalPair(int[] arr, int fromIndex, int toIndex, int value) {
        // value와 연산을 했을 때 합이 0과 가장 가까워지는 쌍을 담는 변수, fromIndex의 value로 초기화
        int optimalPairValue = arr[fromIndex];
        // optimalPairValue와 value 값의 절대값으로 초기화
        int optimalAbs = Math.abs(value + optimalPairValue);

        int left = fromIndex + 1; // 이전 코드에서 fromIndex 값으로 초기화 했으니까, 다음 값으로 변수값 추가
        int right = toIndex;

        while (left <= right) {
            int mid = (left + right) / 2;
            // value와 중앙값의 sum에 대해서 확인
            // 거쳐가는 모든 value가 답이 될 수 있다.
            int sum = value + arr[mid];
            int sumAbs = Math.abs(sum);

            //
            if (sumAbs < optimalAbs) {
                optimalPairValue = arr[mid];
                optimalAbs = sumAbs;
            }

            // sum이 음수면 + 값을 더해줘야 절대값이 작아짐, 그러므로 다음에 조사해야 할 값이 arr[mid] 값보다 더 큰 값
            if (sum < 0) left = mid + 1;
                // sum이 양수이면 - 값을 더해줘야 절대값이 작아질 가능성이 있음
            else if (sum > 0) right = mid - 1;
            else return arr[mid];
        }

        return optimalPairValue;
    }

    private static int findOptiomalValue2(int[] arr, int fromIndex, int toIndex, int value) {
        int left = fromIndex;
        int right = toIndex;

        int optimalPairValue = 0;
        int optimalPairAbs = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = value + arr[mid];
            int sumAbs = Math.abs(sum);
            if (sumAbs < optimalPairAbs) {
                optimalPairValue = arr[mid];
                optimalPairAbs = sumAbs;
            }

            if (sum < 0) { // sum이 음수냐
                left = mid + 1;
            } else if (sum > 0) {  // sum이 양수냐
                right = mid - 1;
            } else { // sum이 0이면 OptimalValue 바로 찾은것.
                return arr[mid];
            }
        }
        return optimalPairValue;
    }
}
