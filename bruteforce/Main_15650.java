package bruteforce;

import java.util.Scanner;

//중복x, 순서x -> O(N C M) = N! / M!(N-M)!
public class Main_15650 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] intArray;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        intArray = new int[M + 1];
    }

    static void recurrenceFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(intArray[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = intArray[k - 1] + 1; cand <= N; cand++) {
                // k 번째에 cand 가 올 수 있으면
                intArray[k] = cand;

                recurrenceFunction(k + 1);

                intArray[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);
        System.out.println(sb);
    }
}

