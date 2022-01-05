package bruteforce;

import java.util.Scanner;

//중복x, 순서x -> O(N C M) = N! / M!(N-M)!
public class Main_15650 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] values;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        values = new int[M + 1];
    }

    static void recurrenceFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(values[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = values[k - 1] + 1; cand <= N; cand++) {
                // k 번째에 cand 가 올 수 있으면
                values[k] = cand;

                recurrenceFunction(k + 1);

                values[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);
        System.out.println(sb);
    }
}

