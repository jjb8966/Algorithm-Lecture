package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2470 {
    //Scanner를 쓰면 시간초과가 나고 BufferedReader를 쓰면 정답이되는 문제... 웬만하면 BufferedReader 쓰는게 좋을듯
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;       //2~10만
    static int[] array;

    static void input() throws IOException {
        String[] temp;
        N = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");

        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(array);
    }

    static void twoPointer() {
        int left = 0, right = N - 1, sum, minimumSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            sum = array[left] + array[right];

            if (minimumSum > Math.abs(sum)) {
                minimumSum = Math.abs(sum);
                result[0] = array[left];
                result[1] = array[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
