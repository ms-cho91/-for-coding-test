import java.util.Scanner;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MyStack {
    public static void main(String[] args) {

        /** stack
         * 선입후출 구조 또는 후입선출 구조
         */

        /** solution
         */

        Stack<Integer> myStack  = new Stack<>();

        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
        myStack.push(5);
        myStack.push(2);
        myStack.push(3);
        myStack.push(7);
        myStack.pop();
        myStack.push(1);
        myStack.push(4);
        myStack.pop();
        // 스택의 최상단 원소부터 출력
        while (!myStack.empty()) {
            System.out.println(myStack.peek());
            myStack.pop();
        }


    }
}