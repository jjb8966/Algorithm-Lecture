package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제
 * P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다. 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.
 *
 * 배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오. 비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다. 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.
 *
 * 입력
 * 첫째 줄에 배열 A의 크기 N이 주어진다. 둘째 줄에는 배열 A의 원소가 0번부터 차례대로 주어진다. N은 50보다 작거나 같은 자연수이고, 배열의 원소는 1,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 비내림차순으로 만드는 수열 P를 출력한다.
 *
 * 예제 입력
 * 3
 * 2 3 1
 * 예제 출력
 * 1 2 0
 */
public class Main_1015 {
    private static Scanner sc = new Scanner(System.in);
    private static Element[] arrayA;
    private static int N;
    private static int[] result;
    private static String[] temp;

    static class Element implements Comparable<Element> {
        int num, idx;

        @Override
        //오름차순 -> this - 매개변수
        public int compareTo(Element other) {
            return this.num - other.num;
        }
    }

    public static void input() {
        N = Integer.parseInt(sc.nextLine());
        arrayA = new Element[N];
        result = new int[N];
        temp = sc.nextLine().split(" ");

        for (int i = 0; i < temp.length; i++) {
            arrayA[i] = new Element();
            arrayA[i].num = Integer.parseInt(temp[i]);
            arrayA[i].idx = i;
        }
    }

    public static void process() {
        Arrays.sort(arrayA);        //숫자로 정렬한 arrayB

        for (int i = 0; i < arrayA.length; i++) {
            result[arrayA[i].idx] = i;
        }
    }
    public static void main(String[] args) {
        input();
        process();

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
