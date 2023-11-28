import java.util.Arrays;
import java.util.Scanner;

public class greedy8 {

    public static void main(String[] args) {

        /** 만들 수 없는 금액
         *  N개의 동전을 가지고 있습니다.
         *  N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램을 작성하세요.
         *  e.g. N=5이고, 각 동전이 각각 3원, 2원, 1원, 1원, 9원짜리(화폐 단위) 동전이라고 가정합시다.
         *  만들 수 없는 양의 정수 금액 중 최솟값은 8원입니다.
         *  e.g. N=3이고, 각 동전이 각각 3원, 5원, 7원짜리(화폐 단위) 동전이라고 가정합시다.
         *  만들 수 없는 양의 정수 금액 중 최솟값은 1원입니다.
         *
         *  입력
         *  첫째 줄에는 동전의 개수를 나타내는 양의 정수 N이 주어집니다. (1<=N<=1,000)
         *  둘째 줄에는 각 동전의 화폐 단위를 나타내는 N개의 자연수가 주어지며,
         *  각 자연수는 공백으로 구분합니다. 이때, 각 화폐 단위는 1,000,000 이하의 자연수 입니다.
         *
         *  출력
         *  첫째 줄에 주어진 동전들로 만들 수 없는 양의 정수 금액 중 최솟값을 출력합니다.
         */

        /** solution
         *  현재까지 만들 수 있는 금액을 기준으로 새로운 동전을 추가하면서 만들 수 없는 최솟값을 찾는 것
         *
         */


        Scanner sc = new Scanner(System.in);

        System.out.println("동전의 갯수 n 입력");

        int n = sc.nextInt();
        int[] coins = new int[n]; //동전들

        for (int i = 0; i < n; ++i) {

            System.out.println(i+1+" 번째 동전을 입력");
            coins[i] = sc.nextInt();

        }

        int result = minUnmakeableAmount(coins);

        System.out.println("만들 수 없는 양의 정수 금액 중 최솟값은 "+result);

    }

    public static int minUnmakeableAmount(int[] coins) {
        Arrays.sort(coins);  // 동전을 오름차순으로 정렬

        int target = 1;  // 만들고자 하는 양의 정수 금액 중 최솟값

        for (int coin : coins) {
            // 현재까지 만들 수 있는 금액(target)보다 현재 동전의 금액이 작거나 같으면
            // 새로운 금액 target + 동전의 금액을 만들 수 있음
            if (target >= coin) {
                target += coin;
            } else {
                break;
            }
        }

        return target;
    }
}