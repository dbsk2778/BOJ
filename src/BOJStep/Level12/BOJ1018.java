package BOJStep.Level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        // 보드 입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;

        // 모든 가능한 8x8 부분 보드 검사
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                minCount = Math.min(minCount, getRepaintCount(board, i, j));
            }
        }

        System.out.println(minCount);
    }

    public static int getRepaintCount(char[][] board, int startX, int startY) {
        char[] firstColors = {'W', 'B'};
        int minCount = Integer.MAX_VALUE;

        // 두 가지 경우에 대해 검사 (첫 타일이 'W' 또는 'B')
        for (char firstColor : firstColors) {
            int repaintCount = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char expectedColor;
                    if ((i + j) % 2 == 0) {
                        expectedColor = firstColor;
                    } else {
                        expectedColor = (firstColor == 'W') ? 'B' : 'W';
                    }

                    if (board[startX + i][startY + j] != expectedColor) {
                        repaintCount++;
                    }
                }
            }

            minCount = Math.min(minCount, repaintCount);
        }

        return minCount;
    }
}
