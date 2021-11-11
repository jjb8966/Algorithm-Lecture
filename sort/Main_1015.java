package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1015 {

    static class Element implements Comparable<Element> {
        int num, idx;

        @Override
        //오름차순 -> 작은게 먼저
        public int compareTo(Element other) {
            return this.num - other.num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Element[] arrayA;
        int N;
        int[] result;
        String[] temp;

        N = Integer.parseInt(sc.nextLine());
        arrayA = new Element[N];
        result = new int[N];
        temp = sc.nextLine().split(" ");

        for (int i = 0; i < temp.length; i++) {
            arrayA[i] = new Element();
            arrayA[i].num = Integer.parseInt(temp[i]);
            arrayA[i].idx = i;
        }

        Arrays.sort(arrayA);        //숫자로 정렬한 arrayB

        for (int i = 0; i < arrayA.length; i++) {
            result[arrayA[i].idx] = i;
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
