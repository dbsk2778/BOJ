package Sort.type;

import java.util.Arrays;

public class BubbleSort {

    /*
     * Bubble Sort
     * 버블 정렬은 두 인접한 원소를 비교하여 순서가 바뀌어있으면 서로 교환하는 정렬 알고리즘
     * 리스트의 끝부터 시작하여 첫 원소까지 진행하며, 이 과정을 전체 리스트가 정렬될 때까지 반복
     * 시간복잡도: O(n^2) -> 리스트의 크기가 커질수록 비효율적인 알고리즘이며, 대부분의 실제 구현에서는 다른 정렬 알고리즘을 사용
     * 공간복잡도: O(1)
     * 장점: 구현이 간단하다.
     * 단점: 시간복잡도가 높다.
     *
     */

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 6, 1, 9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {5, 2, 8, 6, 1, 9};
        bubbleSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    // 기본적인 버블 정렬 구현으로, 배열이 이미 정렬되어 있더라도 항상 모든 요소를 반복 비교
    // 마지막부터 정렬된 숫자가 쌓임
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) { // 입력받은 배열 반복 0 ~ 4까지
            // - i를 하는 이유 -> 제일 큰 수가 맨 마지막으로 정렬이 됨 (맨 마지막은 비교 안해도 됨)
            for (int j = 0; j < len - 1 - i; j++) { // 앞 숫자와 뒤 숫자 서로 비교할 반복문
                // ex) j = 0일 때, arr[0] > arr[0 + 1]로 앞자리가 숫자가 더 크다면
                if (arr[j] > arr[j + 1]) {
                    // 값을 옮겨주기 위해 tmp 변수 선언하여 큰 숫자인 arr[0]에 있는 값을 담아준다.
                    int tmp = arr[j];
                    // 그리고 비어있는 앞자리에 숫자가 작은 뒷자리 숫자를 arr[0]에 넣어준다.
                    arr[j] = arr[j + 1];
                    // 임시로 tmp에 담아뒀던 큰 숫자를 arr[0+1]자리에 담아주면서 위치를 바꿔준다.
                    arr[j + 1] = tmp;
                }
            }
        }
    }


    // 향상된 버블 정렬로, change 플래그를 사용하여 배열이 이미 정렬된 경우 반복을 중지합니다. 따라서, 배열이 이미 정렬되어 있을 경우 최선의 시간 복잡도가 O(n)으로 개선
    public static void bubbleSort2(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n - 1 ; i ++) {
            boolean change = false;
            for(int j = 0 ; j < n - 1 - i ; j ++){
                if(arr[j] > arr[j + 1]) {
                    change = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!change) break;
        }
    }
}
