import java.util.Scanner;
import java.util.Arrays;

public class greedy2 {

    public static void main(String[] args) {

        /** 큰수법칙
         * 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다.
         * 배열의 특정한 번호에 해당하는 수가 연속해서 K번 초과해서 더해질 수 없다.
         * 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
         * e.g. 2, 4, 5, 4, 6으로 이루어진 배열이 있을 때 M이 8이고, K가 3이면 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5 => 46
         * e.g. 3, 4, 3, 4, 3으로 이루어진 배열이 있을 때 M이 7이고 K가 2라고 가정하면 4 + 4 + 4 + 4 + 4 + 4 + 4 + 4 => 48
         *
         * 첫째 줄에 N(2<=N<=1,000), M(1<=M<=10,000), K(1<=K<=10,000)의 자연수가 주어지며, 각 자연수는 공백으로 구분한다.
         * 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 단, 각각의 자연수는 1이상 10,000 이하의 수로 주어진다.
         * 입력으로 주어지는 K는 항상 M보다 작거나 같다
         */

        /** solution
         * 가장 큰 수와 두 번째로 큰 수만 저장하면 된다. 연속으로 더할 수 있는 횟수는 최대 K번이므로 '가장 큰 수를 K번 더하고 두번째로 큰 수를 한 번 더하는 연산'을 반복하면 된다.
         */

        // N, M, K를 공백을 기준으로 구분하여 입력 받기

        System.out.println("배열 크기 n, 총 덧샘 횟수 m, 연속해서 더할 수 있는 횟수 k 입력");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기

        System.out.println("배열에 들어가는 수를 입력");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        int result = 0;


        /*
        while (true) {

            for (int i = 0; i < k; ++i) {

                if (m != 0) {

                    result += first;
                    --m;

                } else {
                    break;
                }

            }

            if (m != 0) {

                result += second;
                --m;

            } else {
                break;
            }

        }
         */

        /** M이 10,000 이하이므로 이 위의 코드 방식으로도 문제를 해결할 수 있지만, M의 크기가 100억 이상처럼 커진다면 시간 초과 판정을 받을 것
         * 반복되는 수열에 대해서 파악
         *
         * N = 5, M = 8, K = 3
         * (6 + 6 + 6 + 5) + (6 + 6 + 6 + 5) = (6 * 3) * 2 + (5 * 2)
         * = 6 * ((8 / 4) * 3) + 5 * (8 - ((8 / 4) * 3))
         *
         * N = 5, M = 9, K = 3
         * (6 + 6 + 6 + 5) + (6 + 6 + 6 + 5) + 6 = (6 * 3) * 2 + (5 * 2) + 6
         * = 6 * ((9 / 4) * 3 + (9 % 4)) + 5 * (9 - ((9 / 4) * 3 + (9 % 4))
         *
         * 예시를 통해 다음과 같은 식을 만들 수 있다.
         * 큰 수 더하는 횟수는 (K * (M / (K+1)) + (M % (K+1)))
         * 그 다음 큰 수 더하는 횟수는 M - (K * (M / (K+1)) + (M % (K+1)))
         */

        //가장 큰 수가 더해지는 횟수
        int firstCnt = (k * (m / (k+1)) + (m % (k+1)));
        int secondCnt = m-firstCnt;

        System.out.println("가장 큰 수가 더해지는 횟수 "+firstCnt);
        System.out.println("두번째 큰 수가 더해지는 횟수 "+secondCnt);

        result = (first*firstCnt) + (second*secondCnt);

        System.out.println("가장 큰 수는 "+result);
    }

}