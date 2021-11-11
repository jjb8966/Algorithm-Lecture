package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11652 {
    static int N;               //카드의 갯수 : 1~10만
    static long[] cards;        //카드의 값 : -2^62 ~ 2^62


    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextLong();
        }
    }

    static void getResult() {
        Arrays.sort(cards);                //카드의 값 오름차순으로 정렬
        int currentCount = 1;
        int maxCount = currentCount;       //만약 가장 많이 가지고 있는 정수가 여러가지라면 가장 작은 것을 출력해야하므로
        long currentNumber = cards[0];
        long maxNumber = currentNumber;

        for (int i = 1; i < cards.length; i++) {
            if (currentNumber == cards[i]) {
                currentCount++;
            } else {
                currentNumber = cards[i];
                currentCount = 1;
            }

            if (maxCount < currentCount) {
                maxCount = currentCount;
                maxNumber = currentNumber;
            }
        }

        System.out.println(maxNumber);
    }

    public static void main(String[] args) {
        input();
        getResult();
    }
}
