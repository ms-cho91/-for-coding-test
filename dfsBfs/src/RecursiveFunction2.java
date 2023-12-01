// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class RecursiveFunction2 {

    public static void recursiveFunction(int i) {
        // 100번째 호출을 했을 때 종료되도록 종료 조건 명시
        if (i == 100) return;
        System.out.println(i + "번째 재귀 함수에서 " + (i + 1) + "번째 재귀함수를 호출합니다.");
        recursiveFunction(i + 1);
        System.out.println(i + "번째 재귀 함수를 종료합니다.");
    }

    public static void main(String[] args) {

        /** recursiveFunction
         * 자기 자신을 다시 호출하는 함수
         * 재귀 함수는 내부적으로 스택 자료구조와 동일하다.
         */

        /** solution
         */

        recursiveFunction(1);
    }
}