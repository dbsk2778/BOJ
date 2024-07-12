package Sort;

public class InsertionSort {

    /*
        삽입정렬 : 현재 비교하고자 하는 target(타겟)과 그 이전의 원소들과 비교하며 자리를 교환(swap)하는 정렬 방법

        [장점]
        1. 추가적인 메모리 소비가 작다.
        2. 거의 정렬 된 경우 매우 효율적이다. 즉, 최선의 경우 O(N)의 시간복잡도를 갖는다.
        3. 안장정렬이 가능하다.

        [단점]
        1. 역순에 가까울 수록 매우 비효율적이다. 즉, 최악의 경우 O(N2)의 시간 복잡도를 갖는다.
        2. 데이터의 상태에 따라서 성능 편차가 매우 크다.
     */

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        insertionSortAsc(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        int[] arr2 = {5, 2, 4, 6, 1, 3};
        int[] result = insertionSortDesc(arr2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static void insertionSortAsc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 얘를 기준으로 앞에 있는 애들과 비교
            int key = arr[i];

            int j = i - 1;
            // 타겟이 이전 원소보다 크기 전 까지 반복
            while(j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];	// 기준 값보다 큰 값들을 한 칸씩 뒤로 이동
                j--;
            }

            /*
             * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
             * 타겟 원소는 j번째 원소 뒤에 와야한다.
             * 그러므로 타겟은 j + 1 에 위치하게 된다.
             * 루프가 종료되면 j는 key 값보다 작거나 같은 값의 인덱스를 가리키거나, 배열의 시작 부분을 넘어서 -1이 되므로 + 1을 해준다.
             */
            arr[j + 1] = key;
        }
    }

    public static int[] insertionSortDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // 현재 key 값보다 큰 값들을 한 칸씩 뒤로 이동
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 적절한 위치에 key 값을 삽입
            arr[j + 1] = key;
        }

        return arr;
    }

}
