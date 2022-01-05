package twopointer;

import java.util.Scanner;

public class Main_1806 {
    private static int N, M;
    private static int[] sequences;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        sequences = new int[N];

        for (int i = 0; i < N; i++) {
            sequences[i] = sc.nextInt();
        }
    }

    public static void twoPointer() {
        int right = 0;
        int sum = 0;
        int count = 0;
        int minCount = N + 1;

        for (int left = 0; left < N; left++) {
            // right를 옮길 수 있을 때 까지 옮기기
            while (right < N && sum < M) {
                sum += sequences[right];
                right++;
            }

            if (sum >= M) {
                count = right - left;
            }

            // 정답 갱신
            if (minCount > count) {
                minCount = count;
            }

            // left - 1을 구간에서 제외
            sum -= sequences[left];
        }

        System.out.println(minCount);
    }

    public static void main(String[] args) {
        input();
        twoPointer();
    }
}
