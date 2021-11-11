package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13144 {
    static int N;       //1~10만
    static int[] array; //각 숫자 : 1~10만
    // --> 결과 sum의 최댓값 : N + (N-1) + ... + 2 + 1 = 약 50억 -> 결과는 long 변수로 담아야함

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];     //right가 빈 공간 array[N]을 가리킬 수 있도록 N+1개로 만듦
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }


    static void twoPointer() {
        int[] count = new int[100001];  //1~10만의 각 숫자가 몇개 있는지를 기록하는 배열
        int right = 0;
        long sum = 0;

        for (int left = 0; left < N; left++) {
            //right 이동시키기
            while (count[array[right]] != 1 && right < N) {  //right가 N이면 가장 오르쪽까지 왔다는 의미이므로 반복문 종료
                count[array[right]]++;
                right++;
            }

            count[array[left]]--;       //left를 오른쪽으로 이동시키면서 기존에 카운팅 되었던 배열을 초기화 시킴

            sum += (long) (right - left);
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
