package twopointer;

import java.util.Scanner;

public class Main_1806 {
    static int N, M;
    static int[] array;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
    }

    static void twoPointer() {
        int right = 0, sum = 0, count = 0, minCount = N + 1;

        for (int left = 0; left < N; left++) {
            // right를 옮길 수 있을 때 까지 옮기기
            while (right < N && sum < M) {
                sum += array[right];
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
            sum -= array[left];
        }

        System.out.println(minCount);
    }

    public static void main(String[] args) {
        input();
        twoPointer();
    }
}
