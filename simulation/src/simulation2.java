import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simulation2 {
    public static void main(String[] args) {

        /** 시각
         * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서
         * 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오.
         * 예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다.
         *
         * 00시 00분 03초
         * 00시 13분 30초
         * 반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각이다.
         *
         * 00시 02분 55초
         * 01시 27분 45초
         *
         * 입력
         * 첫째 줄에 정수 N이 입력된다. (0<=N<=23)
         *
         *출력
         * 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력한다.
         */

        /** solution
         * 하루는 86,400초로, 00시 00분 00초부터 23시 59분 59초까지의 모든 경우는 86,400가지
         * 단순히 시각을 1씩 증가시키면서 3이 하나라도 포함되어 있는지 확인
         * 시, 분, 초에 대한 경우의 수는 23 x 60 x 60이며 3중 반복문을 이용해 계산할 수 있다.
         */


        Scanner sc = new Scanner(System.in);


        System.out.println("시각 0<=n<=23 n 입력");
        int time = sc.nextInt();

        int count = 0;

        // 시, 분, 초에 대한 세 반복문
        for (int h = 0; h <= time; ++h) {
            for (int m = 0; m < 60; ++m) {
                for (int s = 0; s < 60; ++s) {
                    // 시간, 분, 초를 문자열로 합쳐서 문자열에 "3"이 포함되어 있는지 확인
                    String hourMinuteSecond = String.valueOf(h) + String.valueOf(m) + String.valueOf(s);
                    if (hourMinuteSecond.contains("3")) {
                        ++count;
                    }
                }
            }
        }

        System.out.println("경우의 수는 "+count);

    }
}