package Sort;

import java.util.Arrays;

public class ShellSort {

    /*
        셸정렬: 삽입정렬의 장점을 살리고 단점을 보완한 정렬 알고리즘
        삽입 정렬의 단점은 (n - 1)번째 인덱스 원소의 들어가야할 자리가 0번째 인덱스라면 많은 swap()을 해야하는 것
        단점을 보완하기 위하여 간격을 정하여 배열을 부분 배열들로 나누어 어느정도 정렬 시키고, 다시 간격을 줄여 정렬시키는 것을 반복함
     */

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 6, 1, 9};
        shellSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    //셀 정렬 함수
    static void shellSort(int[] a, int n) {
        // h 값(초기 8)은 반복문을 돌 때 마다 절반으로 줄어든다.
        for (int h = n / 2; h > 0; h /= 2) {
            // i는 h(4)부터 시작하고, n(8)까지 반복한다.
            for (int i = h; i < n; i++) {

                // j는 i에서 h만큼 뺀 값부터 시작한다.
                int j; // (1. j는 4-4 = 0)

                // 현재 i 위치의 값을 tmp 변수에 저장한다.
                int tmp = a[i]; // (7)

                // j가 0 이상(배열의 시작)이고, a[j]가 tmp값보다 큰 경우에 반복된다.
                // h만큼 간격이 있으므로, j를 h만큼 감소시킨다.
                // swap
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j]; // j + h 위치에 j위치의 값을 대입한다. (a(0 + 4) = a(0) : 8 로 바뀜
                }
                a[j + h] = tmp; // j + h 위치에 tmp값을 대입한다. a[0] = 7
            }
        }
    }
}
