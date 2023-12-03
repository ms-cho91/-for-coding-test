import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Fruit implements Comparable<Fruit> {

    private String name;
    private int score;

    public Fruit(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Fruit other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class KeyBasedSorting {
    public static void main(String[] args) {

        /** Comparable
         * 객체를 정렬 객체를 비교할 수 있도록 만든다.
         * Comparable과 Comparator는 모두 인터페이스(interface)
         * Comparable 혹은 Comparator을 사용하고자 한다면 인터페이스 내에 선언된 메소드를 '반드시 구현'해야한다
         */

        /** solution
         */

        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore() + ") ");
        }

    }


}