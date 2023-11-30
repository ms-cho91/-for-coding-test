import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simulation6 {
    public static void main(String[] args) {

        /** 문자열 재정렬
         * 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어집니다.
         * 이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에, 그 뒤에 모든 숫자를 더한 값을 이어서 출력합니다.
         * 예를 들어 K1KA5CB7이라는 값이 들어오면 ABCKK13을 출력합니다.
         *
         * 입력
         * 첫째 줄에 하나의 문자열 S가 주어집니다. (1<=S의 길이<=10,000)
         * 출력
         * 첫째 줄에 문제에서 요구하는 정답을 출력합니다.
         */

        /** solution
         *  문자열이 입력되었을 때 문자를 하나씩 확인 별도의 리스트에 저장, 숫자인 경우 따로 합계를 계산
         */

        Scanner sc = new Scanner(System.in);

        // 점수 입력
        System.out.println("문자열 입력");

        String str = sc.next();

        // 문자열을 문자 배열로 변환하여 정렬
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        // 알파벳 부분과 숫자 부분을 나누기 위한 변수
        StringBuilder alphabets = new StringBuilder();
        int sumOfNumbers = 0;

        // 알파벳과 숫자를 나누어서 각각의 StringBuilder에 추가
        for (char ch : charArray) {
            if (Character.isAlphabetic(ch)) {
                alphabets.append(ch);
            } else if (Character.isDigit(ch)) {
                sumOfNumbers  += Character.getNumericValue(ch);
            }
        }

        // 결과 출력
        System.out.println("결과 출력"+alphabets.toString() + sumOfNumbers);
    }

}

