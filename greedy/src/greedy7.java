import java.util.Scanner;

public class greedy7 {

    public static void main(String[] args) {

        /** 문자열 뒤집기
         * 다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있습니다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 합니다.
         * 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것입니다.
         * 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미합니다.
         * 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미합니다.
         * 예를 들어 S = 0001100일 때는 다음과 같습니다.
         * 1. 전체를 뒤집으면 1110011이 됩니다.
         * 2. 4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 두 번 만에 모두 같은 숫자로 만들 수 있습니다.
         * 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있습니다.
         * 문자열 S가 주어졌을 때, 다솜이가 해야 하는 행동의 최소 횟수를 출력하세요.
         *
         * 입력 줄에 0과 1로만 이루어진 문자열 S가 주어집니다. S의 길이는 100만보다 작습니다.
         * 출력 줄에 다솜이가 해야 하는 행동의 최소 횟수를 출력합니다.
         */

        /** solution
         * 다솜이는 모든 숫자를 전부 같게 만드는 것이 목적이다.
         * 따라서 전부 0으로 바꾸는 경우와 전부 1로 바꾸는 경우 중에서 더 적은 횟수를 가지는 경우를 계산
         */


        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 s를 입력");

        String s = sc.next();

        int result = minFlipsToMakeAllDigitsEqual(s);

        System.out.println("가장 최소 횟수 "+result);

    }

    public static int minFlipsToMakeAllDigitsEqual(String s) {
        int flips0 = 0;
        int flips1 = 0;

        // 첫 번째 원소에 대한 처리
        if (s.charAt(0) == '0') {
            ++flips0;
        }
        else {
            ++flips1;
        }

        // 두 번째 원소부터 모든 원소를 확인하며
        for (int i = 1; i < s.length(); ++i) {

            if (s.charAt(i-1) != s.charAt(i)) {
                if(s.charAt(i) == '0') {
                    ++flips0;
                } else {
                    ++flips1;
                }
            }

        }

        int result = Math.min(flips0, flips1);

        return result;
    }
}