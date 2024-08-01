package 생활코딩.BRONZE3.Day2;

import java.io.*;

public class BOJ3009 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] x = br.readLine().split(" ");
        String[] y = br.readLine().split(" ");
        String[] z = br.readLine().split(" ");

        int fourthX = findSpot(Integer.parseInt(x[0]), Integer.parseInt(y[0]), Integer.parseInt(z[0]));
        int fourthY = findSpot(Integer.parseInt(x[1]), Integer.parseInt(y[1]), Integer.parseInt(z[1]));

       bw.write(fourthX + " " + fourthY + "\n");
       bw.flush();
    }

    public static int findSpot(int first, int second, int third) {
        if (first == second) {
            return third;
        } else if (first == third) {
            return second;
        }
        return first;
    }
}
