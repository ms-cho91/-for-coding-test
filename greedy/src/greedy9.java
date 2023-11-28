import java.util.Arrays;
import java.util.Scanner;

public class greedy9 {

    public static void main(String[] args) {

        /** 볼링공 고르기
         * A, B 두 사람이 볼링을 치고 있습니다.
         * 두 사람은 서로 무게가 다른 볼링공을 고르려고 합니다.
         * 볼링공은 총 N개가 있으며 각 볼링공마다 무게가 적혀 있고, 공의 번호는 1번부터 순서대로 부여됩니다.
         * 또한 같은 무게의 공이 여러개 있을 수 있지만, 서로 다른 공으로 간주합니다.
         * 볼링공의 무게는 1부터 M까지의 자연수 형태로 존재합니다.
         * 예를 들어 N이 5이고, M이 3이며 각각의 무게가 차례대로 1, 3, 2, 3, 2일때 각 공의 번호가 차례대로 1번부터 5번까지 부여됩니다.
         * 이때 두 사람이 고를 수 있는 볼링공 번호의 조합을 구하면 다음과 같습니다.
         * (1번, 2번), (1번, 3번), (1번, 4번), (1번, 5번), (2번, 3번), (2번, 5번), (3번, 4번), (4번, 5번)
         * 결과적으로 두 사람이 공을 고르는 경우의 수는 8가지입니다.
         * N개의 공의 무게가 각각 주어질 때, 두 사람이 볼링공을 고르는 경우의 수를 구하는 프로그램을 작성하세요.
         *
         * 입력
         * 첫째 줄에 볼링공의 개수 N, 공의 최대 무게 M이 공백으로 구분되어 각각 자연수 형태로 주어집니다. (1 <= N <= 1,000, 1 <= M <= 10)
         * 둘째 줄에 각 볼링공의 무게 K가 공백으로 구분되어 순서대로 자연수 형태로 주어집니다. (1 <= K <= M)
         *
         * 출력
         * 첫째 줄에 두 사람이 볼링공을 고르는 경우의 수를 출력합니다.
         */

        /** solution
         * 데이터를, 각 번호별 볼링공의 무게가 아닌, 각 무게별 볼링공의 개수로 사용함으로써 N의 시간 복잡도로 해결할 수 있습니다.
         * 각 무게를 순서대로 탐색하며, 해당 무게의 볼링공 개수와 해당 무게보다 높은 볼링공의 개수를 곱함으로써, 가능한 조합의 개수를 계산합니다
         */


        Scanner sc = new Scanner(System.in);

        System.out.println("볼링공 갯수 n 입력");
        int ballCount = sc.nextInt();

        System.out.println("볼링공의 최대 무게 m 입력");
        int maxWeight = sc.nextInt();

        int[] weights = new int[ballCount]; //볼링공 무게

        for (int i = 0; i < ballCount; ++i) {

            System.out.println(i+1+" 번째 볼링공 무게 입력");
            weights[i] = sc.nextInt();

        }

        int result = countBowlingCombinations(ballCount, maxWeight, weights);

        System.out.println("두 사람이 볼링공을 고르는 경우의 수 "+result);

    }

    /*
    //2중 for문 사용 각 요소 접근하면서 다른경우 증감
    public static int countBowlingCombinations(int ballCount, int maxWeight, int[] weights) {

        int totalCount = 0;

        for (int i = 0; i < ballCount - 1; ++i) {
            for (int j = i + 1; j < ballCount; ++j) {
                // 서로 다른 공을 선택하는 경우에만 개수를 증가
                if (weights[i] != weights[j]) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
     */


    /** solution
     * 예를 들어, 각 무게별 볼링공의 개수가 아래와 같다고 가정합시다.
     * 무게가 1인 볼링공 : 1개
     * 무게가 2인 볼링공 : 2개
     * 무게가 3인 볼링공 : 2개
     * 그렇다면, 가능한 조합은 아래와 같습니다.
     * 1(무게가 1인 공의 개수) X 4(무게가 1보다 큰 공의 개수) = 4
     * 2(무게가 2인 공의 개수) X 2(무게가 2보다 큰 공의 개수) = 4
     * 2(무게가 3인 공의 개수) X 0(무게가 3보다 큰 공의 개수) = 0
     * 총 8개의 조합이 존재합니다.
     */
    public static int countBowlingCombinations(int ballCount, int maxWeight, int[] weights) {

        int totalCount = 0;

        // 무게별 볼링공의 개수 정리
        int[] weightCount  = new int[maxWeight];
        for (int ball : weights) {
            ++weightCount[ball-1];
        }

        // 조합 계산
        for (int i = 0; i < weightCount.length; ++i) {
            // i번째 무게보다 높은 무게의 볼링공 개수
            ballCount -= weightCount[i];
            // i번째 무게의 볼링공 개수 * i번째 무게보다 높은 무게의 볼링공 개수
            totalCount += weightCount[i] * ballCount;
        }

        return totalCount;
    }


}