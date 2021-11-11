package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;           // 1~2000
    static int[] array;     // 각 숫자 : -10억~10억
    // 답을 찾는 과정에서 두 수를 더하는 경우 최대값이 20억을 넘지 않으므로 int로 충분

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);     // O(NlogN)
    }

    static void twoPointer() {
        int sumOfGoodNumber = 0;

        for (int i = 0; i < N; i++) {       // O(N)
            int left = 0, right = N - 1;
            int findNumber = array[i];

            while (left < right) {          // left, right의 탐색 -> O(N)      최종 시간복잡도 : O(N^2) -> 4,000,000 (충분)
                int sum = array[left] + array[right];

                // 서로 다른 두 수의 합이어야 하므로 찾는 수와 인덱스가 같으면 left, right를 옮김
                if (i == left) {
                    left++;
                    continue;
                } else if (i == right) {
                    right--;
                    continue;
                }

                // findNumber를 두 수의 합으로 만들 수 있으면 good number
                if (findNumber == sum) {
                    sumOfGoodNumber++;
                    break;
                }

                // 두 수의 합이 찾는 수보다 작으면 더 커지게 해야하므로 left를 오른쪽으로 이동
                if (sum < findNumber) {
                    left++;
                }

                // 두 수의 합이 찾는 수보다 크면 더 작아지게 해야하므로 right를 왼쪽으로 이동
                if (sum > findNumber) {
                    right--;
                }
            }
        }

        System.out.println(sumOfGoodNumber);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
