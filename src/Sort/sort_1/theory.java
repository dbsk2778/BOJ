package Sort.sort_1;

import java.util.Arrays;

public class theory {

    // 정렬: 데이터 집합을 적합한 순서로 배치하는 것
    // 유명한 N^2 알고리즘: 버블 정렬, 삽입 정렬, 선택 정렬
    // 유명한 NlogN 알고리즘: 퀵 정렬, 병합 정렬, 힙 정렬
    // 그 외: 기수 정렬, 계수 정렬, 쉘 정렬, 팀 정렬, 트리 정렬, 블록 정렬, 외부 정렬

    // 최대 1,000,000개의 정수를 오름차순 정렬하는 문제: N^2 알고리즘은 시간초과가 발생
    public static void main(String[] args) {
        sortScoresDescendingOrder(new Score[]{new Score(1), new Score(3), new Score(2), new Score(4), new Score(5), new Score(10), new Score(7), new Score(8), new Score(9), new Score(6)});
//        sortScoresDescendingOrder2(new Score[]{new Score(1), new Score(3), new Score(2), new Score(4), new Score(5), new Score(10), new Score(7), new Score(8), new Score(9), new Score(6)});
//
//        sortNumbers();
//        sortString();
    }

    // 내림차순 정렬 - 삽입 정렬 알고리즘
    public static void sortScoresDescendingOrder(Score[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Score key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j].getScore() < key.getScore()) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        for (Score score : arr) {
            System.out.println(score.getScore());
        }
    }


    // 내림차순 정렬 - 버블 정렬 알고리즘 - 버블 정렬은 인접한 두 요소를 비교하여 정렬하는 방식
    public static void sortScoresDescendingOrder2(Score[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].getScore() < arr[j + 1].getScore()) {
                    Score temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (Score score : arr) {
            System.out.println(score.getScore());
        }
    }


    // 배열을 정리하는 sort 함수가 존재한다. = Arrays.sort() = 오름차순 정렬
    // Primitive[] sort
    // Dual-Pivot Quicksort - 평균 시간복잡도 : NlogN, 최악 시간복잡도 : N^2 : stable하지 않음 (Unstable sort: 같은 값의 순서가 바뀔 수 있음, 어떤 순서도 가능)
    public static void sortNumbers() {
        int[] arr = {2, 3, 1, 4, 5};
        Arrays.sort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    // String은 사전순 정렬임 = 오름차순 정렬이 아님.
    // Object[] sort
    // Tim sort (merge sort 기반) - 평균 시간복잡도 - NlogN, 최악 시간복잡도 - NlogN : stable함 (같은 위상을 가진 값이라면 입력순서가 먼저인 것이 먼저 나옴)
    public static void sortString() {
        String[] arr = {"k8s", "cake", "banana", "cherry", "ramen", "date", "ajax", "elderberry"};
        Arrays.sort(arr);
        for (String str : arr) {
            System.out.println(str);
        }
    }

}
