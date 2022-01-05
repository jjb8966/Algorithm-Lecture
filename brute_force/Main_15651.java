package bruteforce;

import java.util.Scanner;

//중복o , 순서o -> O(N^M)
public class Main_15651 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] values;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        values = new int[M + 1];        //1~M의 인덱스를 사용하기 위해
    }

    //k번째 자리부터 조건에 맞는 원소를 고르는 재귀 함수
    private static void recurrenceFunction(int k) {
        if (k == M + 1) {       //탐색 끝
            for (int i = 1; i <= M; i++) {
                sb.append(values[i] + " ");
            }
            sb.append("\n");
        } else {                //k번째 자리에 올 수 있는 숫자 대입 후 k+1
            for (int cand = 1; cand <= N; cand++) {
                values[k] = cand;

                recurrenceFunction(k + 1);

                values[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recurrenceFunction(1);      //1번째 자리부터 올바른 원소를 고르는 함수\
        System.out.println(sb);
    }
}
