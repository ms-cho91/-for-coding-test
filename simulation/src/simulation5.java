import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simulation5 {
    public static void main(String[] args) {

        /** 럭키 스트레이트
         * 게임의 아웃복서 캐릭터는 필살기인 '럭키 스트레이트' 기술이 있습니다.
         * 이 기술은 매우 강력한 대신에 게임 내에서 점수가 특정 조건을 만족할 때만 사용할 수 있습니다.
         * 특정 조건이란 현재 캐릭터의 점수를 N이라고 할 때 자릿수를 기준으로 점수 N을 반으로 나누어
         * 왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황을 의미합니다.
         * 예를 들어 현재 점수가 123,402라면 왼쪽 부분의 각 자릿수의 합은 1+2+3,
         * 오른쪽 부분의 각 자릿수의 합은 4+0+2이므로 두 합이 6으로 동일하여 럭키 스트레이트를 사용할 수 있습니다.
         * 현재 점수 N이 주어지면 럭키 스트레이트를 사용할 수 있는 상태인지 아닌지를 알려주는 프로그램을 작성하세요.
         *
         * 입력
         * 첫째 줄에 점수 N이 정수로 주어집니다. (10<=N<=99,999,999)
         * 단, 점수 N의 자릿수는 항상 짝수 형태로만 주어집니다. 예를 들어 자릿수가 5인 12,345와 같은 수는 입력으로 들어오지 않습니다.
         *
         * 출력
         * 첫째 줄에 럭키 스트레이트를 사용할 수 있다면 "LUCKY"를, 사용할 수 없다면 "READY"를 출력합니다.
         */

        /** solution
         *  정수형 데이터가 입력으로 들어왔을 때 이를 각 자릿수로 구분하여 합을 계산해야 한다.
         */


        Scanner sc = new Scanner(System.in);

        // 점수 입력
        System.out.println("점수를 입력하시오");
        int point = sc.nextInt();

        // 점수의 자릿수를 반으로 나누기
        String str = Integer.toString(point);
        int length = str.length();
        int mid = length / 2;

        // 왼쪽 부분과 오른쪽 부분의 합 계산
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < mid; i++) {
            leftSum += Character.getNumericValue(str.charAt(i));
            rightSum += Character.getNumericValue(str.charAt(mid + i));
        }

        // 럭키 스트레이트 사용 여부 판단
        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

}

