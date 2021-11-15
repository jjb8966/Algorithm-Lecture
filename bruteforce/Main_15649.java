package bruteforce;

import java.util.Scanner;

//중복x, 순서o -> O(N P M) = N! / (N-M)!
public class Main_15649 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] values;
    static int[] used;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        values = new int[M + 1];
        used = new int[N + 1];        //1부터 N까지의 숫자중 사용된 것이 있으면 1, 없으면 0을 저장
    }

    public static void recurrenceFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(values[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int cand = 1; cand <= N; cand++) {
                if (used[cand] == 1) {
                    continue;
                }

                values[k] = cand;
                used[cand]++;

                recurrenceFunction(k + 1);

                values[k] = 0;
                used[cand]--;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);      //1번째 자리부터 올바른 원소를 고르는 함수\
        System.out.println(sb);
    }
}
