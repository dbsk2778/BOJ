package ExhaustiveSearch;

import java.util.Scanner;

public class _3058 {

    public static void main(String[] args) {
        _3058_();
    }

    // 문제 : 색이 다른 사탕이 인접한 두 칸을 골라 사탕을 서로 교환할 때(단 한번), 같은 색으로 이루어진 가장 긴 연속 부분 행/열의 최댓값
    // 시간 복잡도 : O(N^2 * (2N^2 + 2N^2)) = O(N^4) = 50^4 = 625000
    // 1. 가능한 모든 쌍의 사탕을 서로 교환한다.
    // 2. 교환한 상태에서 가장 긴 연속 부분 행/열을 찾는다.
    // 3. 교환한 사탕을 원상복구한다.

    public static void _3058_() {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 3 <= N <= 50

        int ans = 0;
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = scan.next().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // j + 1이 N이랑 같거나 크면 값이 없음. 무조건 이 조건을 만족해야 함 (옆쪽)
                // 인접한 값의 색이 달라야 함
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swapCandy(map, i, j, i, j + 1);
                    // 최대 연속 행 or 최대 연속 열
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i, j + 1);  // 원상 복구
                }
                // 아래쪽
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i + 1, j);
                }
            }
        }
        System.out.println(ans);
    }

    // 1. 가능한 모든 쌍의 사탕을 서로 교환한다.
    // 인접한 [r1, c1]과 [r2, c2]를 바꾼다.
    // ex. (1,1)과 교환 가능한 사탕 : (0,1) / (1,2) / (2,1) / (1,0) :  각 -1, +1
    // ex. (1,2)와 교환 가능한 사탕 : (0,2) / (1,3) / (2,2) / (1,1)  // 교환 상태가 중복 (1,1) / (1,2)


    // 이러한 격자 형식의 문제를 풀때는 중복되는 부분이 많기 때문에, 인접한 네 방향 모두가 아닌 증가하는 두 방향만 확인해보기. (r값이나, c 값이 증가하는 방향)
    // (1,2) -> (1,3) / (2,2) 이 두 가지만 확인
    // 실제로 모든 값을 다 확인할 수 있는가? 이 두가지만 확인해도 모든 경우를 확인할 수 있다 !!
    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];  // 교환하기 전에 임시로 저장
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }

    // 2. 교환한 상태에서 가장 긴 연속 부분 행/열을 찾는다.
    // 이전 값과 비교하여 연속성을 판단하는 방법
    // 가장 긴 연속 열
    public static int findMaxRow(char[][] map) {
        int N = map.length;
        int maxRow = 0;
        for (char[] chars : map) { // 어떤 row를 고정
            int len = 1;  // 1부터 시작
            for (int c = 1; c < N; c++) {  // column을 증가시키면서 (1은 이미 확인)
                if (chars[c] == chars[c - 1]) {  // 같은 색이라면 길이 증가
                    len++;
                } else { // 다른 색이라면
                    maxRow = Math.max(maxRow, len);  // 최대값 갱신 (연속성 하나가 마무리 된 상태)
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len); // 마지막 연속 부분에 대해 따로 답에 반영
        }
        return maxRow;
    }

    // 가장 긴 연속 행
    public static int findMaxColumn(char[][] map) {
        int N = map.length;
        int maxColumn = 0;
        for (int c = 0; c < N; c++) {  // 가장 긴 행을 구하기 위해 column을 고정
            int len = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) {
                    len++;
                } else {
                    maxColumn = Math.max(maxColumn, len);
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
        return maxColumn;
    }

    // 2. 교환한 상태에서 가장 긴 연속 부분 행/열을 찾는다.
    // targetColor 변수를 이용해 연속성을 판단하는 방법
    // 가장 긴 연속 열
    public static int findMaxRow2(char[][] map) {
        int N = map.length;
        int maxRow = 0;
        for (char[] chars : map) {  // 어떤 row를 고정
            int len = 0;
            char currentColor = chars[0];
            for (int c = 0; c < N; c++) {
                if (chars[c] == currentColor) {
                    len++;
                } else {
                    currentColor = chars[c];
                    len = 1;
                }
                maxRow = Math.max(maxRow, len);
            }
        }
        return maxRow;
    }

    // 가장 긴 연속 열
    public static int findMaxColumn2(char[][] map) {
        int N = map.length;
        int maxColumn = 0;
        for (int c = 0; c < N; c++) {  // 어떤 row를 고정
            int len = 0;
            char currentColor = map[0][c];
            for (char[] chars : map) {
                if (chars[c] == currentColor) {
                    len++;
                } else {
                    currentColor = chars[c];
                    len = 1;
                }
                maxColumn = Math.max(maxColumn, len);
            }
        }
        return maxColumn;
    }

}
