package bruteforce;

import java.util.Scanner;

//중복o, 순서x -> O(N^M)보단 작음
public class Main_15652 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] intArray;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        intArray = new int[M + 1];
    }

    private static void recurrenceFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(intArray[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int cand = 1; cand <= N; cand++) {
                intArray[k] = cand;
                if (intArray[k - 1] <= intArray[k]) {
                    recurrenceFunction(k + 1);
                    intArray[k] = 0;
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
