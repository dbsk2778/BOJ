package BOJStep.Level9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ11653_TImeOver {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> primes = findPrimes(N);
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while (N > 1) {
            if (N % primes.get(idx) == 0) {
                answer.add(primes.get(idx));
                N = N / primes.get(idx);
            } else {
                idx++;
            }
        }

        for (int i : answer) {
            bw.write(i + "\n");
        }
        bw.flush();
    }

    private static List<Integer> findPrimes(int N) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) primes.add(i);
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
