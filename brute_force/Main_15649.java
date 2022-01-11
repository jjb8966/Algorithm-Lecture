package brute_force;

import java.util.Scanner;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 1 ≤ M ≤ N ≤ 8
 * [입력]
 * 3 2
 * [출력]
 * 1 2
 * 1 3
 * 2 1
 * 2 3
 * 3 1
 * 3 2
 */

// 중복x, 순서o -> 시간복잡도 : O(N P M) = N! / (N-M)!
public class Main_15649 {

    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] values;
    private static int[] used;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        values = new int[M + 1];
        used = new int[N + 1];        //1부터 N까지의 숫자중 사용된 것이 있으면 1, 없으면 0을 저장
    }

    public static void recurrenceFunction(int digit) {
        // 1. 탐색이 끝난 경우
        if (digit == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(values[i] + " ");     // 1번째 자리값 + 2번째 자리값 + ... + M번째 자리값
            }
            sb.append("\n");
        } else {        // 2. 탐색이 남은 경우
            for (int candidate = 1; candidate <= N; candidate++) {
                if (used[candidate] == 1) {     // candidate가 사용된 적이 있는 숫자이면 pass
                    continue;
                }

                values[digit] = candidate;
                used[candidate]++;

                recurrenceFunction(digit + 1);

                values[digit] = 0;      // 재귀함수의 마지막 함수가 호출된 후 반드시 초기화를 해줘야함
                used[candidate]--;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);      //1번째 자리부터 올바른 원소를 고르는 함수
        System.out.println(sb);
    }
}
