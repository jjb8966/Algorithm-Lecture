package sort;

import java.util.*;

public class Main_10825 {
    private static Scanner sc = new Scanner(System.in);
    private static Element[] Students;
    private static int count;

    static class Element implements Comparable<Element> {
        String name;
        int korean, english, math;

        @Override
        public int compareTo(Element other) {       //정렬의 기준이 되는 메소드
            // 국어 - 내림차순 -> 높은게 먼저
            if (this.korean != other.korean) {
                return other.korean - this.korean;
            }
            // 영어 - 오름차순 -> 낮은게 먼저
            if (this.english != other.english) {
                return this.english - other.english;
            }
            // 수학 - 내림차순 -> 높은게 먼저
            if (this.math != other.math) {
                return other.math - this.math;
            }
            return this.name.compareTo(other.name);
        }
    }

    public static void input() {
        count = Integer.parseInt(sc.nextLine());
        Students = new Element[count];

        for (int i = 0; i < count; i++) {
            Students[i] = new Element();

            StringTokenizer st = new StringTokenizer(sc.nextLine());

            Students[i].name = st.nextToken();
            Students[i].korean = Integer.parseInt(st.nextToken());
            Students[i].english = Integer.parseInt(st.nextToken());
            Students[i].math = Integer.parseInt(st.nextToken());
        }
    }

    public static void sortStudents() {
        Arrays.sort(Students);      //오버라이딩 한 compareTo 메소드를 기준으로 정렬
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (Element temp : Students) {
            sb.append(temp.name + "\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        input();
        sortStudents();
        print();
    }
}