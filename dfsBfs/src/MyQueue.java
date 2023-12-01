import java.util.LinkedList;
import java.util.Queue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MyQueue {
    public static void main(String[] args) {

        /** queue
         * 선입선출 구조
         */

        /** solution
         */

        // 큐 생성
        Queue<Integer> myQueue = new LinkedList<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        myQueue.offer(5);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(7);
        myQueue.poll();
        myQueue.offer(1);
        myQueue.offer(4);
        myQueue.poll();
        // 먼저 들어온 원소부터 추출
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }

    }
}