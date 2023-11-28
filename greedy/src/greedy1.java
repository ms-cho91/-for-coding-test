import java.util.Scanner;

public class greedy1 {

    public static void main(String[] args) {

        /** 거스름돈
         * 500원, 100원, 50원, 10원 동전이 있는 상황에서 손님에게 거슬러 줘야 할 돈이 항상 10의 배수일 때, 최소한의 동전 개수로 거슬러 주는 문제
         * 화폐의 종류가 K개라고 할 때 아래 소스코드의 시간 복잡도는 O(K) 이다.
         * 시간 복잡도에서 거슬러 주어야 할 돈 N은 찾아볼 수 없다. 이 알고리즘의 시간 복잡도는 동전의 총 종류에만 영향을 받고, 거슬러 줘야하는 금액의 크기와는 무관하다.
         * 가장 큰 화폐 단위부터' 돈을 거슬러 주는 것 가지고 있는 동전 중에서 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 없기 때문이다
         */

        int n;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        System.out.println("거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다. 손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러 줘야 할 동전의 최소 개수를 구하라. 단, 거슬러 줘야 할 돈은 항상 10의 배수이다.");
        Scanner sc = new Scanner(System.in);
        System.out.println("거슬러 줘야 할 돈을 입력하시오");
        n = sc.nextInt();

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.println("거슬러 줘야 할 동전의 최소 개수는 "+cnt+"개");

    }

}