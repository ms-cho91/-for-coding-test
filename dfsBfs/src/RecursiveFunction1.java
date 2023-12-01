// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class RecursiveFunction1 {

    public static void recursiveFunction() {
        System.out.println("재귀 함수를 호출합니다.");
        recursiveFunction();
    }

    public static void main(String[] args) {

        /** recursiveFunction
         * 자기 자신을 다시 호출하는 함수
         * 재귀 함수는 내부적으로 스택 자료구조와 동일하다.
         */

        /** solution
         */

        recursiveFunction();
    }
}