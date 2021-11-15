package bruteforce;

import java.util.Scanner;

//중복o, 순서x -> O(N^M)보단 작음
public class Main_15652 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] values;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        values = new int[M + 1];
    }

    private static void recurrenceFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(values[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int cand = 1; cand <= N; cand++) {
                values[k] = cand;
                if (values[k - 1] <= values[k]) {
                    recurrenceFunction(k + 1);
                    values[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);
        System.out.println(sb);
    }
}
