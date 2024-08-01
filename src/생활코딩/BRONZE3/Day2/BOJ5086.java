package 생활코딩.BRONZE3.Day2;

import java.io.*;

public class BOJ5086 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] strs = br.readLine().split(" ");
            int first = Integer.parseInt(strs[0]);
            int second = Integer.parseInt(strs[1]);
            String str = "";
            if (first == 0 && second == 0) {
                break;
            }

            // 약수인지, 아무것도 아닌지 둘 중 하나만 확인
            if (first < second) {
                str = checkNums(first, second) ? "factor" : "neither";
            }
            // 배수인지, 아무것도 아닌지 둘 중 하나 확인
            else {
                str = checkNums(second, first) ? "multiple" : "neither";
            }

            bw.write(str + "\n");
        }
        bw.flush();
    }

    public static boolean checkNums(int min, int max) {
        return max % min == 0;
    }
}
